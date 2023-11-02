package br.dev.igorcardoso.myroute.useCases.serviceMonthUseCase.DTOs;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record CreateServiceMonthDTO(
    @NotNull
    LocalDate dateMonth,
    @NotNull
    UUID carId
) {
    
}
