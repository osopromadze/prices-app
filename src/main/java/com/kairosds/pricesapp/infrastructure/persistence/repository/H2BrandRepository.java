package com.kairosds.pricesapp.infrastructure.persistence.repository;

import com.kairosds.pricesapp.application.ports.output.BrandOutputPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class H2BrandRepository implements BrandOutputPort {

    private final SpringDataH2BrandRepository repository;

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }
}
