package com.kairosds.pricesapp.domain.service;

import com.kairosds.pricesapp.application.ports.input.ExistsBrandUseCase;
import com.kairosds.pricesapp.application.ports.output.BrandOutputPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BrandService implements ExistsBrandUseCase {

    private final BrandOutputPort brandOutputPort;

    @Override
    public boolean existsById(Long id) {
        return brandOutputPort.existsById(id);
    }
}
