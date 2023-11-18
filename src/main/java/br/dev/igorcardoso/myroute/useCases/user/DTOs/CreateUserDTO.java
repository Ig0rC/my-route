package br.dev.igorcardoso.myroute.useCases.user.DTOs;

import br.dev.igorcardoso.myroute.useCases.employee.DTOs.CreateEmployeeDTO;
import jakarta.validation.constraints.NotBlank;

public record CreateUserDTO(
    @NotBlank String email,
    @NotBlank String password,
    CreateEmployeeDTO employee) {
}
