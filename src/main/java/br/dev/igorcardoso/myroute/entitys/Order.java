package br.dev.igorcardoso.myroute.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import br.dev.igorcardoso.myroute.useCases.order.DTOs.CreateOrderRequestDTO;

import java.util.UUID;

@Entity(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
  @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;

  @Column(nullable = false)
  private String year;

  @Column(nullable = false)
  private String month;

  // @ManyToOne
  @Column(name = "car_id")
  private UUID carId;

  @Column(name = "user_id")
  private UUID userId;

  @Column(name = "created_at")
  @CreationTimestamp
  private String createdAt;

  public Order(CreateOrderRequestDTO createOrderDTO) {
    this.year = createOrderDTO.getYear();
    this.month = createOrderDTO.getMonth();
    this.carId = createOrderDTO.getCarId();
    this.userId = createOrderDTO.getUserId();
  }
}
