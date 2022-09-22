package com.kairosds.pricesapp.infrastructure.persistence.repository;

import com.kairosds.pricesapp.infrastructure.persistence.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataH2BrandRepository extends JpaRepository<BrandEntity, Long> {
}
