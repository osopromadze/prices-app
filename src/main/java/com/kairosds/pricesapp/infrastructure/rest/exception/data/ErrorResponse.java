package com.kairosds.pricesapp.infrastructure.rest.exception.data;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
public class ErrorResponse {
    private final List<String> errorMessages;
}
