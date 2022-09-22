package com.kairosds.pricesapp.mock;

import com.kairosds.pricesapp.domain.model.Price;
import com.kairosds.pricesapp.utils.TestUtils;

import java.math.BigDecimal;
import java.util.List;

public class MockData {

    public static List<Price> getPrices() {
        String eur = "EUR";

        Price price1 = Price.builder()
                .brandId(1L)
                .startDate(TestUtils.createDateTime("14-06-2020 00:00:00"))
                .endDate(TestUtils.createDateTime("31-12-2020 23:59:59"))
                .priceList(1L)
                .productId(35455L)
                .priority(0L)
                .price(BigDecimal.valueOf(35.5))
                .curr(eur)
                .build();

        Price price2 = Price.builder()
                .brandId(1L)
                .startDate(TestUtils.createDateTime("14-06-2020 15:00:00"))
                .endDate(TestUtils.createDateTime("14-06-2020 18:30:00"))
                .priceList(2L)
                .productId(35455L)
                .priority(1L)
                .price(BigDecimal.valueOf(25.45))
                .curr(eur)
                .build();

        Price price3 = Price.builder()
                .brandId(1L)
                .startDate(TestUtils.createDateTime("15-06-2020 00:00:00"))
                .endDate(TestUtils.createDateTime("15-06-2020 11:00:00"))
                .priceList(3L)
                .productId(35455L)
                .priority(1L)
                .price(BigDecimal.valueOf(30.5))
                .curr(eur)
                .build();

        Price price4 = Price.builder()
                .brandId(1L)
                .startDate(TestUtils.createDateTime("15-06-2020 16:00:00"))
                .endDate(TestUtils.createDateTime("31-12-2020 23:59:59"))
                .priceList(4L)
                .productId(35455L)
                .priority(1L)
                .price(BigDecimal.valueOf(38.95))
                .curr(eur)
                .build();

        return List.of(price1, price2, price3, price4);
    }
}
