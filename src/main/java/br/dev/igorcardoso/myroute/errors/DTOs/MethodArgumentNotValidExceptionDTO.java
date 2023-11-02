package br.dev.igorcardoso.myroute.errors.DTOs;

import org.springframework.validation.FieldError;

public record MethodArgumentNotValidExceptionDTO(
    String field, String message
) {
    public MethodArgumentNotValidExceptionDTO(FieldError fieldError) {
        this(fieldError.getField(), fieldError.getDefaultMessage());
    }
}
