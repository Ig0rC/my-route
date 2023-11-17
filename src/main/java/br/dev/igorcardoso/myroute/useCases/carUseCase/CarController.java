package br.dev.igorcardoso.myroute.useCases.carUseCase;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.igorcardoso.myroute.useCases.carUseCase.DTOs.CreateCarRequestDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cars")
public class CarController {

  @Autowired
  private CreateCarUseCase createCarUseCase;

  @PostMapping("/")
  public ResponseEntity create(HttpServletRequest request, @RequestBody @Valid CreateCarRequestDTO createCarDTO) {
    UUID userId = UUID.fromString((String) request.getAttribute("userId"));

    createCarDTO.setUserId(userId);

    this.createCarUseCase.execute(createCarDTO);

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}
