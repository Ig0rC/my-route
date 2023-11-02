package br.dev.igorcardoso.myroute.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.igorcardoso.myroute.entitys.DescriptionService;
import java.util.List;

public interface IDescriptionServiceRepository extends JpaRepository<DescriptionService, UUID> {
  long countByServiceDayId(UUID serviceDayId);

  List<DescriptionService> findByServiceDayIdOrderByOrderNumberAsc(UUID serviceDayId);

  DescriptionService findOneByOrderNumberAndServiceDayId(Integer orderNumber, UUID serviceDayId);
}
