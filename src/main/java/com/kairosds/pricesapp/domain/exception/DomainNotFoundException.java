package com.kairosds.pricesapp.domain.exception;

public abstract class DomainNotFoundException extends RuntimeException {
    protected DomainNotFoundException(final String message) {
        super(message);
    }
}
