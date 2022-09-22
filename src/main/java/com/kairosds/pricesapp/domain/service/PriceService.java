package com.kairosds.pricesapp.domain.service;

import com.kairosds.pricesapp.domain.exception.PriceNotFoundException;
import com.kairosds.pricesapp.domain.model.Price;
import com.kairosds.pricesapp.domain.repository.PriceRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class PriceService {

    private final PriceRepository priceRepository;

    public Price getPrice(LocalDateTime date, Long productId, Long brandId) {
        List<Price> prices = priceRepository.getPrices().stream()
                .filter(price -> price.getBrandId().equals(brandId))
                .filter(price -> price.getProductId().equals(productId))
                .filter(price -> date.isAfter(price.getStartDate()) && date.isBefore(price.getEndDate()))
                .collect(Collectors.toList());

        Long highestPriority = prices.stream()
                .mapToLong(price -> price.getPriority())
                .max()
                .orElse(-1);

        return prices.stream()
                .filter(p -> highestPriority.equals(p.getPriority()))
                .findFirst()
                .orElseThrow(() -> new PriceNotFoundException(String.format("Price for product with id %d not found", productId)));
    }
}
