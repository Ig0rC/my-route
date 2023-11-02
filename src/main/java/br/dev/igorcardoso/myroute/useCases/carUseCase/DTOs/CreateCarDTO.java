package br.dev.igorcardoso.myroute.useCases.carUseCase.DTOs;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateCarDTO(
        @NotBlank String year,
        @NotBlank String plate,
        @NotBlank String mark,
        @NotBlank String model,
        @NotNull UUID userId) {

}
