package com.kairosds.pricesapp.infrastructure.persistence.repository;

import com.kairosds.pricesapp.infrastructure.persistence.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataH2PriceRepository extends JpaRepository<PriceEntity, Long> {
}
