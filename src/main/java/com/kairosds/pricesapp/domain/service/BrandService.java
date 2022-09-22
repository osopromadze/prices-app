package com.kairosds.pricesapp.domain.service;

import com.kairosds.pricesapp.domain.repository.BrandRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;

    public boolean existsById(Long id) {
        return brandRepository.existsById(id);
    }
}
