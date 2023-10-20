package br.dev.igorcardoso.myroute.useCases.userUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.igorcardoso.myroute.entitys.Employee;
import br.dev.igorcardoso.myroute.entitys.User;
import br.dev.igorcardoso.myroute.useCases.employeeUseCase.IEmployeeRepository;
import br.dev.igorcardoso.myroute.useCases.userUseCase.DTOs.CreateUserDTO;
import jakarta.transaction.Transactional;

@Service
public class CreateUserUseCase {

  @Autowired
  private IUserRepository userRepository;
  @Autowired
  IEmployeeRepository employeeRepository;

  @Transactional
  public void execute(CreateUserDTO userDTO) throws Exception {
    User isExistsUser = this.userRepository.findByEmail(userDTO.email());

    if (isExistsUser != null) {
      throw new Exception("Email já cadastrado!");
    }

    User user = new User(userDTO);

    User createdUser = this.userRepository.save(user);

    Employee employee = new Employee(userDTO.employee());

    employee.setUser(createdUser);

    System.out.println(employee);

    this.employeeRepository.save(employee);
  }
}
