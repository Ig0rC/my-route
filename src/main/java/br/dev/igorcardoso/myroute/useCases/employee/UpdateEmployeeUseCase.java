package br.dev.igorcardoso.myroute.useCases.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.igorcardoso.myroute.entitys.Employee;
import br.dev.igorcardoso.myroute.repositories.IEmployeeRepository;
import br.dev.igorcardoso.myroute.useCases.employee.DTOs.UpdateEmployeeRequestDTO;
import jakarta.validation.Valid;

@Service
public class UpdateEmployeeUseCase {

  @Autowired
  public IEmployeeRepository employeeRepository;

  public void execute(UpdateEmployeeRequestDTO updateEmployeeDTO) {
    Employee employee = this.employeeRepository.findOneById(updateEmployeeDTO.id()).orElse(null);

    employee.setFullName(updateEmployeeDTO.fullName());
    employee.getUser().setEmail(updateEmployeeDTO.email());
    employee.setLotNumber(updateEmployeeDTO.lotNumber());
    employee.setPosition(updateEmployeeDTO.position());
    employee.setRegistration(updateEmployeeDTO.registration());

    this.employeeRepository.save(employee);
  }
}
