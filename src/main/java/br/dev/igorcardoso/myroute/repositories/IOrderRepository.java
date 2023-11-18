package br.dev.igorcardoso.myroute.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.igorcardoso.myroute.entitys.Order;
import java.util.List;

public interface IOrderRepository extends JpaRepository<Order, UUID> {
  Optional<Order> findByYearAndMonthAndUserId(String year, String month, UUID userId);

  List<Order> findByUserId(UUID userId);
}
