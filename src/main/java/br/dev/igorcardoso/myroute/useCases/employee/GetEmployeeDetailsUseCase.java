package br.dev.igorcardoso.myroute.useCases.employee;

import org.springframework.stereotype.Service;

import br.dev.igorcardoso.myroute.entitys.Employee;
import br.dev.igorcardoso.myroute.repositories.IEmployeeRepository;
import br.dev.igorcardoso.myroute.useCases.employee.DTOs.GetEmployeeDetailsRequestDTO;
import br.dev.igorcardoso.myroute.useCases.employee.DTOs.GetEmployeeDetailsResponseDTO;
import jakarta.validation.Valid;

@Service
public class GetEmployeeDetailsUseCase {

  public IEmployeeRepository employeeRepository;

  public GetEmployeeDetailsUseCase(IEmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  public GetEmployeeDetailsResponseDTO execute(@Valid GetEmployeeDetailsRequestDTO GetEmployeeDetailsDTO) {
    Employee employee = this.employeeRepository.findOneByUserId(GetEmployeeDetailsDTO.id());

    return new GetEmployeeDetailsResponseDTO(employee);
  }
}
