package com.kairosds.pricesapp.domain.service;

import com.kairosds.pricesapp.domain.model.Price;
import com.kairosds.pricesapp.domain.repository.PriceRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PriceService {

    private final PriceRepository priceRepository;

    public List<Price> getPrices() {
        return priceRepository.getPrices();
    }
}
