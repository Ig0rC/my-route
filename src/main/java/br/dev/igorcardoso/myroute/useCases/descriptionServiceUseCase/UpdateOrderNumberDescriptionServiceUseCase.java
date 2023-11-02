package br.dev.igorcardoso.myroute.useCases.descriptionServiceUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.igorcardoso.myroute.repositories.IDescriptionServiceRepository;
import br.dev.igorcardoso.myroute.useCases.descriptionServiceUseCase.DTOs.UpdateOrderNumberDescriptionServiceDTO;

@Service
public class UpdateOrderNumberDescriptionServiceUseCase {

  @Autowired
  IDescriptionServiceRepository descriptionServiceRepository;

  public void execute(UpdateOrderNumberDescriptionServiceDTO data) throws Exception {
    if (data.orderNumber() == 0) {
      throw new Exception("Posição 0 é invalida!");
    }

    Integer maxOrderNumber = (int) this.descriptionServiceRepository.countByServiceDayId(
        data.serviceDayId());

    if (maxOrderNumber < data.orderNumber()) {
      throw new Exception("Posição maior que o total de registros!");
    }

    var descriptionService = this.descriptionServiceRepository.findById(
        data.id()).orElseThrow();

    if (Math.abs(descriptionService.getOrderNumber() - data.orderNumber()) > 1) {
      throw new Exception("Só é possível alterar uma posição por vez!");
    }

    var isExistsOrderNumberDescriptionService = this.descriptionServiceRepository
        .findOneByOrderNumberAndServiceDayId(
            data.orderNumber(),
            data.serviceDayId());

    if (isExistsOrderNumberDescriptionService != null) {
      int newOrderNumber = (isExistsOrderNumberDescriptionService.getOrderNumber() > descriptionService
          .getOrderNumber())
              ? isExistsOrderNumberDescriptionService.getOrderNumber() - 1
              : isExistsOrderNumberDescriptionService.getOrderNumber() + 1;

      isExistsOrderNumberDescriptionService.setOrderNumber(newOrderNumber);

      this.descriptionServiceRepository.save(isExistsOrderNumberDescriptionService);
    }

    descriptionService.setOrderNumber(data.orderNumber());

    this.descriptionServiceRepository.save(descriptionService);
  }
}
