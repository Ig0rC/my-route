package br.dev.igorcardoso.myroute.useCases.descriptionServiceUseCase.DTOs;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateDescriptionServiceDTO(
    @NotNull
    UUID serviceDayId,
    @NotBlank
    String description
) {
    
}
