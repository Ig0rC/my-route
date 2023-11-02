package br.dev.igorcardoso.myroute.useCases.descriptionServiceUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.igorcardoso.myroute.entitys.DescriptionService;
import br.dev.igorcardoso.myroute.repositories.IDescriptionServiceRepository;
import br.dev.igorcardoso.myroute.useCases.descriptionServiceUseCase.DTOs.CreateDescriptionServiceDTO;

@Service
public class CreateDescriptionServiceUseCase {

  @Autowired
  private IDescriptionServiceRepository descriptionServiceRepository;

  public void execute(CreateDescriptionServiceDTO createDescriptionServiceDTO) {
    Integer maxOrderNumber = (int) this.descriptionServiceRepository.countByServiceDayId(
        createDescriptionServiceDTO.serviceDayId());

    DescriptionService descriptionService = new DescriptionService(
        createDescriptionServiceDTO);

    descriptionService.setOrderNumber(maxOrderNumber + 1);

    System.out.println(descriptionService);

    this.descriptionServiceRepository.save(descriptionService);
  }
}
