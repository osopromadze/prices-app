package com.kairosds.pricesapp.domain.exception;

public class PriceNotFoundException extends DomainNotFoundException {
    public PriceNotFoundException(String message) {
        super(message);
    }
}
