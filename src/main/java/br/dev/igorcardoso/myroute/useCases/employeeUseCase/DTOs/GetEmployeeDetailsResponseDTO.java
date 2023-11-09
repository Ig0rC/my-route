package br.dev.igorcardoso.myroute.useCases.employeeUseCase.DTOs;

import java.util.UUID;

import br.dev.igorcardoso.myroute.entitys.Employee;

public record GetEmployeeDetailsResponseDTO(
    UUID id, String email, String registration, String fullName, String position, String lotNumber, String createdAt) {

  public GetEmployeeDetailsResponseDTO(
      Employee employee) {
    this(employee.getId(),
        employee.getUser().getEmail(),
        employee.getFullName(),
        employee.getFullName(),
        employee.getPosition(),
        employee.getLotNumber(),
        employee.getCreatedAt());
  }
}
