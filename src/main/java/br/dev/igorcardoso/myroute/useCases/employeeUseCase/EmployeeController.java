package br.dev.igorcardoso.myroute.useCases.employeeUseCase;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.igorcardoso.myroute.entitys.Employee;
import br.dev.igorcardoso.myroute.entitys.User;
import br.dev.igorcardoso.myroute.useCases.employeeUseCase.DTOs.GetEmployeeDetailsRequestDTO;
import br.dev.igorcardoso.myroute.useCases.employeeUseCase.DTOs.GetEmployeeDetailsResponseDTO;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

  @Autowired
  public GetEmployeeDetailsUseCase getEmployeeDetailsUseCase;

  @GetMapping()
  public ResponseEntity<GetEmployeeDetailsResponseDTO> show(HttpServletRequest request) {
    UUID userId = UUID.fromString((String) request.getAttribute("userId"));
    System.out.println(userId);

    var getEmployeeDetailsDTO = new GetEmployeeDetailsRequestDTO(userId);

    var employee = this.getEmployeeDetailsUseCase.execute(getEmployeeDetailsDTO);

    return ResponseEntity.ok(employee);
  }
}
