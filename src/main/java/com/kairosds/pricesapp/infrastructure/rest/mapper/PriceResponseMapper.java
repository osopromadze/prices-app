package com.kairosds.pricesapp.infrastructure.rest.mapper;

import com.kairosds.pricesapp.domain.model.Price;
import com.kairosds.pricesapp.infrastructure.rest.data.response.PriceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;

@Mapper
public interface PriceResponseMapper {

    @Mapping(source = "date", target = "date")
    PriceResponse toPriceResponse(Price price, LocalDateTime date);
}
