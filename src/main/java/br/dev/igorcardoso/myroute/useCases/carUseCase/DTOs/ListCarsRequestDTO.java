package br.dev.igorcardoso.myroute.useCases.carUseCase.DTOs;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record ListCarsRequestDTO(@NotNull UUID userId) {

}
