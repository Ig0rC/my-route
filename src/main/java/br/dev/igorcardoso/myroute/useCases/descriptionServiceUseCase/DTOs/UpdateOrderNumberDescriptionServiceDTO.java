package br.dev.igorcardoso.myroute.useCases.descriptionServiceUseCase.DTOs;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record UpdateOrderNumberDescriptionServiceDTO(
    @NotNull
    UUID id,
    @NotNull
    UUID serviceDayId,
    Integer orderNumber
) {
    
}
