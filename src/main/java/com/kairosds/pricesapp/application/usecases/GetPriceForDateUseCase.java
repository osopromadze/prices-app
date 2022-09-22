package com.kairosds.pricesapp.application.usecases;

import com.kairosds.pricesapp.application.dto.PriceForDateInput;
import com.kairosds.pricesapp.application.dto.PriceForDateOutput;
import com.kairosds.pricesapp.application.mapper.PriceMapper;
import com.kairosds.pricesapp.domain.exception.BrandNotFoundException;
import com.kairosds.pricesapp.domain.exception.PriceNotFoundException;
import com.kairosds.pricesapp.domain.model.Price;
import com.kairosds.pricesapp.domain.service.BrandService;
import com.kairosds.pricesapp.domain.service.PriceService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class GetPriceForDateUseCase {

    private final PriceService priceService;
    private final BrandService brandService;

    public PriceForDateOutput execute(PriceForDateInput input) {
        boolean brandExists = brandService.existsById(input.getBrandId());

        if (!brandExists) {
            throw new BrandNotFoundException(String.format("Brand with id %d not found", input.getBrandId()));
        }

        List<Price> prices = priceService.getPrices().stream()
                .filter(price -> price.getBrandId().equals(input.getBrandId()))
                .filter(price -> price.getProductId().equals(input.getProductId()))
                .filter(price -> input.getDate().isAfter(price.getStartDate()) && input.getDate().isBefore(price.getEndDate()))
                .collect(Collectors.toList());

        Long highestPriority = prices.stream()
                .mapToLong(price -> price.getPriority())
                .max()
                .orElse(-1);

        Price price = prices.stream()
                .filter(p -> highestPriority.equals(p.getPriority()))
                .findFirst()
                .orElseThrow(() -> new PriceNotFoundException(String.format("Price for product with id %d not found", input.getProductId())));

        PriceMapper priceMapper = new PriceMapper();

        return priceMapper.toOutput(price, input.getDate());
    }
}
