package br.dev.igorcardoso.myroute.useCases.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.igorcardoso.myroute.entitys.Employee;
import br.dev.igorcardoso.myroute.entitys.User;
import br.dev.igorcardoso.myroute.repositories.IEmployeeRepository;
import br.dev.igorcardoso.myroute.repositories.IUserRepository;
import br.dev.igorcardoso.myroute.useCases.user.DTOs.CreateUserDTO;

import org.springframework.security.crypto.password.PasswordEncoder;
import jakarta.transaction.Transactional;

@Service
public class CreateUserUseCase {

  @Autowired
  private IUserRepository userRepository;
  @Autowired
  IEmployeeRepository employeeRepository;
  @Autowired
  PasswordEncoder passwordEncoder;

  @Transactional
  public void execute(CreateUserDTO userDTO) throws Exception {
    User isExistsUser = this.userRepository.findByEmail(userDTO.email());

    if (isExistsUser != null) {
      throw new Exception("Email já cadastrado!");
    }

    User user = new User(userDTO);

    String passwordHashred = passwordEncoder.encode(user.getPassword());

    user.setPassword(passwordHashred);

    User createdUser = this.userRepository.save(user);

    Employee employee = new Employee(userDTO.employee());

    employee.setUser(createdUser);

    this.employeeRepository.save(employee);
  }
}
