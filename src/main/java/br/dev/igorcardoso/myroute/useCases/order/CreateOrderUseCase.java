package br.dev.igorcardoso.myroute.useCases.order;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.igorcardoso.myroute.entitys.Order;
import br.dev.igorcardoso.myroute.repositories.IOrderRepository;
import br.dev.igorcardoso.myroute.useCases.order.DTOs.CreateOrderRequestDTO;
import jakarta.validation.Valid;

@Service
public class CreateOrderUseCase {

  @Autowired
  public IOrderRepository orderRepository;

  public Order execute(@Valid CreateOrderRequestDTO createOrderDTO) throws Exception {
    Order order = new Order(createOrderDTO);

    var isExistsOrder = this.orderRepository
        .findByYearAndMonthAndUserId(
            createOrderDTO.getYear(),
            createOrderDTO.getMonth(),
            createOrderDTO.getUserId())
        .orElse(null);

    System.out.println(isExistsOrder);

    if (isExistsOrder != null) {
      throw new Exception("Já tem registro de ordem de serviço no período: " + createOrderDTO.getMonth() + "/"
          + createOrderDTO.getYear());
    }

    return this.orderRepository.save(order);
  }
}
