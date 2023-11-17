package br.dev.igorcardoso.myroute.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.igorcardoso.myroute.entitys.Car;

public interface ICarRepository extends JpaRepository<Car, UUID> {
  Car[] findAllByUserId(UUID userId);

  Optional<Car> findOneByIdAndUserId(UUID id, UUID userId);
}
