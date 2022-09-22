package com.kairosds.pricesapp.infrastructure.persistence.mapper;

import com.kairosds.pricesapp.domain.model.Price;
import com.kairosds.pricesapp.infrastructure.persistence.entity.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PricePersistenceMapper {

    @Mapping(source = "priceEntity.brand.id", target = "brandId")
    Price toPrice(PriceEntity priceEntity);
}
