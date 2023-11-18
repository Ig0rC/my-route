package br.dev.igorcardoso.myroute.useCases.order.DTOs;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record ListOrdersRequestDTO(@NotNull UUID userId) {

}
