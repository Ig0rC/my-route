package br.dev.igorcardoso.myroute.useCases.descriptionServiceUseCase;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.igorcardoso.myroute.entitys.DescriptionService;
import br.dev.igorcardoso.myroute.repositories.IDescriptionServiceRepository;

@Service
public class ListDescriptionServiceUseCase {

  @Autowired
  IDescriptionServiceRepository descriptionServiceRepository;

  public List<DescriptionService> execute(UUID serviceDayId) {
    List<DescriptionService> descriptionsService = this.descriptionServiceRepository
        .findByServiceDayIdOrderByOrderNumberAsc(serviceDayId);

    return descriptionsService;
  }
}
