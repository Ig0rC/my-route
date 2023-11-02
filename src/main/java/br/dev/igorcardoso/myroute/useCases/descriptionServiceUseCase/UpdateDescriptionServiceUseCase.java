package br.dev.igorcardoso.myroute.useCases.descriptionServiceUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.igorcardoso.myroute.entitys.DescriptionService;
import br.dev.igorcardoso.myroute.repositories.IDescriptionServiceRepository;
import br.dev.igorcardoso.myroute.useCases.descriptionServiceUseCase.DTOs.UpdateDescriptionServiceDTO;
import br.dev.igorcardoso.myroute.utils.NonNullPropertyCopier;

@Service
public class UpdateDescriptionServiceUseCase {

  @Autowired
  private IDescriptionServiceRepository descriptionServiceRepository;

  public DescriptionService execute(UpdateDescriptionServiceDTO data) throws Exception {
    DescriptionService descriptionService = this.descriptionServiceRepository.findById(
        data.id()).orElse(null);

    if (descriptionService == null) {
      throw new Exception("Descrição não existe!");
    }
    System.out.println("ANTES");
    System.out.println(data);
    System.out.println(descriptionService);
    System.out.println("DEPOIS");

    NonNullPropertyCopier.copyNonNullProperties(data, descriptionService);
    System.out.println("DEPOIS");
    System.out.println(descriptionService);

    DescriptionService descriptionServiceUpdated = this.descriptionServiceRepository.save(descriptionService);

    return descriptionServiceUpdated;
  }
}
