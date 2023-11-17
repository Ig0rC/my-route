package br.dev.igorcardoso.myroute.useCases.carUseCase;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.igorcardoso.myroute.entitys.Car;
import br.dev.igorcardoso.myroute.useCases.carUseCase.DTOs.CreateCarRequestDTO;
import br.dev.igorcardoso.myroute.useCases.carUseCase.DTOs.GetCarDetailsRequestDTO;
import br.dev.igorcardoso.myroute.useCases.carUseCase.DTOs.ListCarsRequestDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cars")
public class CarController {

  @Autowired
  private CreateCarUseCase createCarUseCase;
  @Autowired
  private ListCarsUseCase listCarsUseCase;
  @Autowired
  private GetCarDetailsUseCase getCarDetailsUseCase;

  @PostMapping("/")
  public ResponseEntity create(HttpServletRequest request, @RequestBody @Valid CreateCarRequestDTO createCarDTO) {
    UUID userId = UUID.fromString((String) request.getAttribute("userId"));

    createCarDTO.setUserId(userId);

    this.createCarUseCase.execute(createCarDTO);

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping("/")
  public ResponseEntity listAll(HttpServletRequest request) {
    UUID userId = UUID.fromString((String) request.getAttribute("userId"));

    System.out.println(userId);

    ListCarsRequestDTO listCarsDTO = new ListCarsRequestDTO(userId);

    Car[] cars = this.listCarsUseCase.execute(listCarsDTO);

    return ResponseEntity.ok(cars);
  }

  @GetMapping("{id}")
  public ResponseEntity show(@PathVariable(name = "id") UUID id, HttpServletRequest request) {
    UUID userId = UUID.fromString((String) request.getAttribute("userId"));

    GetCarDetailsRequestDTO getCarDetailsDTO = new GetCarDetailsRequestDTO(id, userId);

    Car car = this.getCarDetailsUseCase.execute(getCarDetailsDTO);

    return ResponseEntity.ok(car);
  }
}
