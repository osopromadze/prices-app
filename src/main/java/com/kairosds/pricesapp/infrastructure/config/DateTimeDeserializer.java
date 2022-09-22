package com.kairosds.pricesapp.infrastructure.config;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.kairosds.pricesapp.infrastructure.rest.exception.BadRequestException;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeDeserializer extends StdDeserializer<LocalDateTime> {

    private static final String FORMAT = "dd-MM-yyyy HH:mm:ss";

    protected DateTimeDeserializer() {
        super(LocalDateTime.class);
    }

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        String value = p.readValueAs(String.class);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(FORMAT);

        try {
            return LocalDateTime.from(dateTimeFormatter.parse(value));
        } catch (DateTimeException ex) {
            String message = String.format("date must be in this format: %s", FORMAT);
            throw new BadRequestException(message);
        }
    }
}
