package com.kairosds.pricesapp.infrastructure.persistence.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "brand")
@Getter
public class BrandEntity {
    @Id
    private Long id;

    private String name;
}
