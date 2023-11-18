package br.dev.igorcardoso.myroute.useCases.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import br.dev.igorcardoso.myroute.entitys.Order;
import br.dev.igorcardoso.myroute.repositories.IOrderRepository;
import br.dev.igorcardoso.myroute.useCases.order.DTOs.ListOrdersRequestDTO;

@Service
public class ListOrdersUseCase {

  @Autowired
  private IOrderRepository orderRepository;

  public List<Order> execute(ListOrdersRequestDTO listOrdersDTO) {

    List<Order> orders = this.orderRepository.findByUserId(listOrdersDTO.userId());

    return orders;
  }
}
