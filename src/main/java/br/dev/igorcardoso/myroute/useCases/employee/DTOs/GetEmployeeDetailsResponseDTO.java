package br.dev.igorcardoso.myroute.useCases.employee.DTOs;

import java.util.UUID;

import br.dev.igorcardoso.myroute.entitys.Employee;

public record GetEmployeeDetailsResponseDTO(
    UUID id, String email, String registration, String fullName, String position, String lotNumber,
    String createdAt) {

  public GetEmployeeDetailsResponseDTO(
      Employee employee) {
    this(employee.getId(),
        employee.getUser().getEmail(),
        employee.getRegistration(),
        employee.getFullName(),
        employee.getPosition(),
        employee.getLotNumber(),
        employee.getCreatedAt());
  }
}
