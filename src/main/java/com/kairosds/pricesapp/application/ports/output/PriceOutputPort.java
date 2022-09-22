package com.kairosds.pricesapp.application.ports.output;

import com.kairosds.pricesapp.domain.model.Price;

import java.util.List;

public interface PriceOutputPort {
    List<Price> getPrices();
}
