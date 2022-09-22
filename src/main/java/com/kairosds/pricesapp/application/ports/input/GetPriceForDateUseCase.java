package com.kairosds.pricesapp.application.ports.input;

import com.kairosds.pricesapp.domain.model.Price;

import java.time.LocalDateTime;

public interface GetPriceForDateUseCase {
    Price getPriceForDate(LocalDateTime date, Long productId, Long BrandId);
}
