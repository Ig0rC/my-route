package br.dev.igorcardoso.myroute.useCases.order.DTOs;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateOrderRequestDTO {
  @NotNull
  String year;
  @NotNull
  String month;
  @NotNull
  UUID carId;
  UUID userId;
}
