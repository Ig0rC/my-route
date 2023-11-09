package br.dev.igorcardoso.myroute.useCases.employee;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.dev.igorcardoso.myroute.useCases.employee.DTOs.GetEmployeeDetailsRequestDTO;
import br.dev.igorcardoso.myroute.useCases.employee.DTOs.GetEmployeeDetailsResponseDTO;
import br.dev.igorcardoso.myroute.useCases.employee.DTOs.UpdateEmployeeRequestDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

  @Autowired
  public GetEmployeeDetailsUseCase getEmployeeDetailsUseCase;
  @Autowired
  public UpdateEmployeeUseCase updateEmployeeDetailsUseCase;

  @GetMapping()
  public ResponseEntity<GetEmployeeDetailsResponseDTO> show(HttpServletRequest request) {
    UUID userId = UUID.fromString((String) request.getAttribute("userId"));
    System.out.println(userId);

    var getEmployeeDetailsDTO = new GetEmployeeDetailsRequestDTO(userId);

    var employee = this.getEmployeeDetailsUseCase.execute(getEmployeeDetailsDTO);

    return ResponseEntity.ok(employee);
  }

  @PutMapping()
  public ResponseEntity<String> update(
      @RequestBody @Valid UpdateEmployeeRequestDTO updateEmployeeDTO,
      HttpServletRequest request) {
    this.updateEmployeeDetailsUseCase.execute(updateEmployeeDTO);

    return ResponseEntity.ok("Atualizado com sucesso!");
  }
}
