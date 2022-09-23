package com.kairosds.pricesapp.application.usecases;

import com.kairosds.pricesapp.application.dto.PriceForDateInput;
import com.kairosds.pricesapp.application.dto.PriceForDateOutput;
import com.kairosds.pricesapp.application.mapper.PriceMapper;
import com.kairosds.pricesapp.domain.exception.BrandNotFoundException;
import com.kairosds.pricesapp.domain.model.Price;
import com.kairosds.pricesapp.domain.service.BrandService;
import com.kairosds.pricesapp.domain.service.PriceService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetPriceForDateUseCase {

    private final PriceService priceService;

    public PriceForDateOutput execute(PriceForDateInput input) {

        Price price = priceService.getPrice(input.getDate(), input.getProductId(), input.getBrandId());

        return new PriceMapper().toOutput(price, input.getDate());
    }
}
