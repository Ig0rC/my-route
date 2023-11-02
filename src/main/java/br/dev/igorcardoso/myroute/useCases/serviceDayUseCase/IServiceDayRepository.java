package br.dev.igorcardoso.myroute.useCases.serviceDayUseCase;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.igorcardoso.myroute.entitys.ServiceDay;
import java.time.LocalDate;
import java.util.List;



public interface IServiceDayRepository extends JpaRepository<ServiceDay, UUID> {
    List<ServiceDay> findByServiceDate(LocalDate serviceDate);
}
