package com.kairosds.pricesapp.domain.repository;

import com.kairosds.pricesapp.domain.model.Price;

import java.util.List;

public interface PriceRepository {
    List<Price> getPrices();
}
