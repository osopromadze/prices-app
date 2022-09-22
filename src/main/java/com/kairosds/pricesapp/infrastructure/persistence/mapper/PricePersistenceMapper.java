package com.kairosds.pricesapp.infrastructure.persistence.mapper;

import com.kairosds.pricesapp.domain.model.Price;
import com.kairosds.pricesapp.infrastructure.persistence.entity.PriceEntity;
import org.springframework.stereotype.Component;

@Component
public class PricePersistenceMapper {

    public Price toPrice(PriceEntity priceEntity) {
        return Price.builder()
                .id(priceEntity.getId())
                .brandId(priceEntity.getBrand().getId())
                .startDate(priceEntity.getStartDate())
                .endDate(priceEntity.getEndDate())
                .priceList(priceEntity.getPriceList())
                .productId(priceEntity.getProductId())
                .priority(priceEntity.getPriority())
                .price(priceEntity.getPrice())
                .curr(priceEntity.getCurr())
                .build();
    }
}
