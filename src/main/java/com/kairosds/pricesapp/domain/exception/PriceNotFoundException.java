package com.kairosds.pricesapp.domain.exception;

public class PriceNotFoundException extends DomainNotFoundException {
    public PriceNotFoundException(final String message) {
        super(message);
    }
}
