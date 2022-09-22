package com.kairosds.pricesapp.application.mapper;

import com.kairosds.pricesapp.application.dto.PriceForDateOutput;
import com.kairosds.pricesapp.domain.model.Price;

import java.time.LocalDateTime;

public class PriceMapper {

    public PriceForDateOutput toOutput(Price price, LocalDateTime date) {
        return PriceForDateOutput.builder()
                .productId(price.getProductId())
                .brandId(price.getBrandId())
                .priceList(price.getPriceList())
                .price(price.getPrice())
                .date(date)
                .build();
    }

}
