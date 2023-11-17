package br.dev.igorcardoso.myroute.useCases.carUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.igorcardoso.myroute.repositories.ICarRepository;
import br.dev.igorcardoso.myroute.useCases.carUseCase.DTOs.UpdateCarRequestDTO;
import br.dev.igorcardoso.myroute.utils.NonNullPropertyCopier;

@Service
public class UpdateCarUseCase {

  @Autowired
  private ICarRepository carRepository;

  public void execute(UpdateCarRequestDTO updateCarDTO) {
    var car = this.carRepository.findById(updateCarDTO.id()).orElseThrow();

    NonNullPropertyCopier.copyNonNullProperties(updateCarDTO, car);

    this.carRepository.save(car);
  }
}
