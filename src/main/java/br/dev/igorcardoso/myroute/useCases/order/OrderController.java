package br.dev.igorcardoso.myroute.useCases.order;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.igorcardoso.myroute.entitys.Order;
import br.dev.igorcardoso.myroute.useCases.order.DTOs.CreateOrderRequestDTO;
import br.dev.igorcardoso.myroute.useCases.order.DTOs.ListOrdersRequestDTO;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/order")
public class OrderController {

  @Autowired
  private CreateOrderUseCase createOrderUseCase;
  @Autowired
  private ListOrdersUseCase listOrdersUseCase;

  @PostMapping
  public ResponseEntity<Order> create(HttpServletRequest request, @RequestBody CreateOrderRequestDTO createOrderDTO)
      throws Exception {
    UUID userId = UUID.fromString((String) request.getAttribute("userId"));

    createOrderDTO.setUserId(userId);

    Order order = this.createOrderUseCase.execute(createOrderDTO);

    return ResponseEntity.status(HttpStatus.CREATED).body(order);
  }

  @GetMapping
  public ResponseEntity<List<Order>> list(HttpServletRequest request) {
    UUID userId = UUID.fromString((String) request.getAttribute("userId"));

    ListOrdersRequestDTO listOrdersDTO = new ListOrdersRequestDTO(userId);

    List<Order> orders = this.listOrdersUseCase.execute(listOrdersDTO);

    return ResponseEntity.ok(orders);
  }
}
