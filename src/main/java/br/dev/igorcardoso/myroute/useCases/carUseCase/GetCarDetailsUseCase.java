package br.dev.igorcardoso.myroute.useCases.carUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.igorcardoso.myroute.entitys.Car;
import br.dev.igorcardoso.myroute.repositories.ICarRepository;
import br.dev.igorcardoso.myroute.useCases.carUseCase.DTOs.GetCarDetailsRequestDTO;
import jakarta.validation.Valid;

@Service
public class GetCarDetailsUseCase {

  @Autowired
  private ICarRepository carRepository;

  public Car execute(@Valid GetCarDetailsRequestDTO getCarDetailsDTO) {
    var car = this.carRepository.findOneByIdAndUserId(
        getCarDetailsDTO.id(), getCarDetailsDTO.userId()).orElse(null);

    return car;
  }
}
