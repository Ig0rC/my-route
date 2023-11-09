package br.dev.igorcardoso.myroute.useCases.employee.DTOs;

import jakarta.validation.constraints.NotBlank;

public record CreateEmployeeDTO(
    @NotBlank String fullName,
    String position,
    String registration,
    String lotNumber) {

}
