package com.kairosds.pricesapp.application.ports.input;

import com.kairosds.pricesapp.domain.model.Price;

import java.util.List;

public interface GetPricesUseCase {
    List<Price> getPrices();
}
