package br.dev.igorcardoso.myroute.useCases.employeeUseCase.DTOs;

import jakarta.validation.constraints.NotBlank;

public record CreateEmployeeDTO(
    @NotBlank String fullName,
    String position,
    String registration,
    String lotNumber) {

}
