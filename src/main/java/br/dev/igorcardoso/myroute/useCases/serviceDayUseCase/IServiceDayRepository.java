package br.dev.igorcardoso.myroute.useCases.serviceDayUseCase;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.igorcardoso.myroute.entitys.ServiceDay;

public interface IServiceDayRepository extends JpaRepository<ServiceDay, UUID> {
    
}
