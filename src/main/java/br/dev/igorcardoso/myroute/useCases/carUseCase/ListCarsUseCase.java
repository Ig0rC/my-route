package br.dev.igorcardoso.myroute.useCases.carUseCase;

import org.springframework.stereotype.Service;

import br.dev.igorcardoso.myroute.entitys.Car;
import br.dev.igorcardoso.myroute.repositories.ICarRepository;
import br.dev.igorcardoso.myroute.useCases.carUseCase.DTOs.ListCarsRequestDTO;
import jakarta.validation.Valid;

@Service
public class ListCarsUseCase {

  private ICarRepository carRepository;

  public ListCarsUseCase(ICarRepository carRepository) {
    this.carRepository = carRepository;
  }

  public Car[] execute(@Valid ListCarsRequestDTO listCarsDTO) {
    Car[] cars = this.carRepository.findAllByUserId(listCarsDTO.userId());

    return cars;
  }
}
