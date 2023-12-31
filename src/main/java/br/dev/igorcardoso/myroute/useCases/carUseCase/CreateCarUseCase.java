package br.dev.igorcardoso.myroute.useCases.carUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.igorcardoso.myroute.entitys.Car;
import br.dev.igorcardoso.myroute.repositories.ICarRepository;
import br.dev.igorcardoso.myroute.useCases.carUseCase.DTOs.CreateCarRequestDTO;

@Service
public class CreateCarUseCase {

  @Autowired
  private ICarRepository carRepository;

  public void execute(CreateCarRequestDTO carDTO) {
    Car car = new Car(carDTO);

    this.carRepository.save(car);
  }
}
