package br.dev.igorcardoso.myroute.useCases.carUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.igorcardoso.myroute.useCases.carUseCase.DTOs.CreateCarDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cars")
public class CarController {

  @Autowired
  private CreateCarUseCase createCarUseCase;

  @PostMapping("/")
  public ResponseEntity create(@RequestBody @Valid CreateCarDTO carDTO) {

    this.createCarUseCase.execute(carDTO);

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}
