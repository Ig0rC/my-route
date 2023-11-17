package br.dev.igorcardoso.myroute.useCases.carUseCase.DTOs;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record GetCarDetailsRequestDTO(
    @NotNull UUID id,
    UUID userId) {
}
