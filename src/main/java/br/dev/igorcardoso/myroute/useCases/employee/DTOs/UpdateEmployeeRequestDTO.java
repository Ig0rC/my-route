package br.dev.igorcardoso.myroute.useCases.employee.DTOs;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateEmployeeRequestDTO(
    @NotNull UUID id,
    @NotBlank String email,
    @NotBlank String registration,
    @NotBlank String fullName,
    @NotBlank String position,
    @NotBlank String lotNumber) {
}
