package com.kairosds.pricesapp.domain.service;

import com.kairosds.pricesapp.application.ports.input.GetPriceForDateUseCase;
import com.kairosds.pricesapp.application.ports.input.GetPricesUseCase;
import com.kairosds.pricesapp.application.ports.output.PriceOutputPort;
import com.kairosds.pricesapp.domain.exception.BrandNotFoundException;
import com.kairosds.pricesapp.domain.exception.PriceNotFoundException;
import com.kairosds.pricesapp.domain.model.Price;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class PriceService implements GetPricesUseCase, GetPriceForDateUseCase {

    private final PriceOutputPort priceOutputPort;

    private final BrandService brandService;

    @Override
    public List<Price> getPrices() {
        return priceOutputPort.getPrices();
    }

    @Override
    public Price getPriceForDate(LocalDateTime date, Long productId, Long brandId) {

        boolean brandExists = brandService.existsById(brandId);

        if (!brandExists) {
            throw new BrandNotFoundException(String.format("Brand with id %d not found", brandId));
        }

        List<Price> prices = getPrices().stream()
                .filter(price -> price.getBrandId().equals(brandId))
                .filter(price -> price.getProductId().equals(productId))
                .filter(price -> date.isAfter(price.getStartDate()) && date.isBefore(price.getEndDate()))
                .collect(Collectors.toList());

        Long highestPriority = prices.stream()
                .mapToLong(price -> price.getPriority())
                .max()
                .orElse(-1);

        return prices.stream()
                .filter(price -> highestPriority.equals(price.getPriority()))
                .findFirst()
                .orElseThrow(() -> new PriceNotFoundException(String.format("Price for product with id %d not found", productId)));
    }
}
