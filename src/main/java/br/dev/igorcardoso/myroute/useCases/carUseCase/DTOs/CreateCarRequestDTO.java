package br.dev.igorcardoso.myroute.useCases.carUseCase.DTOs;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateCarRequestDTO {
  @NotBlank
  String year;
  @NotBlank
  String plate;
  @NotBlank
  String mark;
  @NotBlank
  String model;
  UUID userId;
}
