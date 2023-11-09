package br.dev.igorcardoso.myroute.useCases.authentication.DTOs;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationDTO(
    @NotBlank String email,
    @NotBlank String password) {

}
