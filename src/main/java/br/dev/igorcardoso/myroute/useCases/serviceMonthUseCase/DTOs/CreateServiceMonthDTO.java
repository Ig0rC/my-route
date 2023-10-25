package br.dev.igorcardoso.myroute.useCases.serviceMonthUseCase.DTOs;

import java.util.Date;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record CreateServiceMonthDTO(
    @NotNull
    Date dateMonth,
    @NotNull
    UUID carId
) {
    
}
