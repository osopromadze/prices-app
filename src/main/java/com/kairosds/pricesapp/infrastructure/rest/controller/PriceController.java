package com.kairosds.pricesapp.infrastructure.rest.controller;

import com.kairosds.pricesapp.application.dto.PriceForDateInput;
import com.kairosds.pricesapp.application.dto.PriceForDateOutput;
import com.kairosds.pricesapp.application.usecases.GetPriceForDateUseCase;
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

    private final GetPriceForDateUseCase getPriceForDateUseCase;

    @GetMapping
    public PriceForDateOutput getPrice(@Valid @RequestBody PriceForDateInput input) {

        return getPriceForDateUseCase.execute(input);
    }
}
