package com.kairosds.pricesapp.infrastructure.config;

import com.kairosds.pricesapp.domain.service.BrandService;
import com.kairosds.pricesapp.domain.service.PriceService;
import com.kairosds.pricesapp.infrastructure.persistence.mapper.PricePersistenceMapper;
import com.kairosds.pricesapp.infrastructure.persistence.repository.H2BrandRepository;
import com.kairosds.pricesapp.infrastructure.persistence.repository.SpringDataH2BrandRepository;
import com.kairosds.pricesapp.infrastructure.persistence.repository.SpringDataH2PriceRepository;
import com.kairosds.pricesapp.infrastructure.persistence.repository.H2PriceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public H2BrandRepository h2BrandRepository(SpringDataH2BrandRepository springDataH2BrandRepository) {
        return new H2BrandRepository(springDataH2BrandRepository);
    }

    @Bean
    public BrandService brandService(H2BrandRepository h2BrandRepository) {
        return new BrandService(h2BrandRepository);
    }

    @Bean
    public H2PriceRepository h2PriceRepository(SpringDataH2PriceRepository springDataH2PriceRepository, PricePersistenceMapper pricePersistenceMapper) {
        return new H2PriceRepository(springDataH2PriceRepository, pricePersistenceMapper);
    }

    @Bean
    public PriceService priceService(H2PriceRepository h2PriceRepository, BrandService brandService) {
        return new PriceService(h2PriceRepository, brandService);
    }
}
