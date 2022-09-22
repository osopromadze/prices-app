package com.kairosds.pricesapp.infrastructure.persistence.repository;

import com.kairosds.pricesapp.domain.repository.BrandRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class H2BrandRepository implements BrandRepository {

    private final SpringDataH2BrandRepository repository;

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }
}
