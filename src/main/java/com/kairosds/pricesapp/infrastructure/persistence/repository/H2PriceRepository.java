package com.kairosds.pricesapp.infrastructure.persistence.repository;

import com.kairosds.pricesapp.domain.model.Price;
import com.kairosds.pricesapp.domain.repository.PriceRepository;
import com.kairosds.pricesapp.infrastructure.persistence.entity.PriceEntity;
import com.kairosds.pricesapp.infrastructure.persistence.mapper.PricePersistenceMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class H2PriceRepository implements PriceRepository {

    private final SpringDataH2PriceRepository repository;
    private final PricePersistenceMapper pricePersistenceMapper;

    @Override
    public List<Price> getPrices() {
        List<PriceEntity> priceEntities = repository.findAll();

        return priceEntities.stream()
                .map(priceEntity -> pricePersistenceMapper.toPrice(priceEntity))
                .collect(Collectors.toList());
    }
}
