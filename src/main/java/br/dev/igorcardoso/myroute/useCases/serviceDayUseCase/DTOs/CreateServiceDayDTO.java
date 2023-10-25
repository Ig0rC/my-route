package br.dev.igorcardoso.myroute.useCases.serviceDayUseCase.DTOs;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateServiceDayDTO(
    @NotNull
    LocalDate serviceDate,
    @NotBlank
    String departureTime,
    @NotBlank
    String arrivalTime,
    @NotNull
    Integer departureOdometer,
    @NotNull
    Integer arrivalOdometer,
    @NotNull
    UUID serviceMonthId
) {
    
    
}
