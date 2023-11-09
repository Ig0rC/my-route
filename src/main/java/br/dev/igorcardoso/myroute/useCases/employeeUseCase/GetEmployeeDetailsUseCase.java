package br.dev.igorcardoso.myroute.useCases.employeeUseCase;

import org.springframework.stereotype.Service;

import br.dev.igorcardoso.myroute.entitys.Employee;
import br.dev.igorcardoso.myroute.repositories.IEmployeeRepository;
import br.dev.igorcardoso.myroute.useCases.employeeUseCase.DTOs.GetEmployeeDetailsRequestDTO;
import br.dev.igorcardoso.myroute.useCases.employeeUseCase.DTOs.GetEmployeeDetailsResponseDTO;

@Service
public class GetEmployeeDetailsUseCase {

  public IEmployeeRepository employeeRepository;

  public GetEmployeeDetailsUseCase(IEmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

public GetEmployeeDetailsResponseDTO execute(GetEmployeeDetailsRequestDTO GetEmployeeDetailsDTO) {
    Employee employee = this.employeeRepository.findOneByUserId(GetEmployeeDetailsDTO.id());

    return new GetEmployeeDetailsResponseDTO(employee);
  }
}
