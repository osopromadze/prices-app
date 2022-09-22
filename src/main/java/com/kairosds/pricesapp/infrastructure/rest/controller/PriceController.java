package com.kairosds.pricesapp.infrastructure.rest.controller;

import com.kairosds.pricesapp.domain.exception.BrandNotFoundException;
import com.kairosds.pricesapp.domain.model.Price;
import com.kairosds.pricesapp.domain.service.BrandService;
import com.kairosds.pricesapp.domain.service.PriceService;
import com.kairosds.pricesapp.infrastructure.rest.data.request.PriceRequest;
import com.kairosds.pricesapp.infrastructure.rest.data.response.PriceResponse;
import com.kairosds.pricesapp.infrastructure.rest.mapper.PriceResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "price")
@RequiredArgsConstructor
public class PriceController {

    private final PriceService priceService;
    private final BrandService brandService;
    private final PriceResponseMapper priceResponseMapper;

    @GetMapping
    public PriceResponse getPrice(@Valid @RequestBody PriceRequest priceRequest) {

//        boolean brandExists = brandService.existsById(priceRequest.getBrandId());
//
//        if (!brandExists) {
//            throw new BrandNotFoundException(String.format("Brand with id %d not found", priceRequest.getBrandId()));
//        }

        Price price = priceService.getPriceForDate(priceRequest.getDate(), priceRequest.getProductId(), priceRequest.getBrandId());

        return priceResponseMapper.toPriceResponse(price, priceRequest.getDate());
    }
}
