package br.dev.igorcardoso.myroute.useCases.serviceMonthUseCase;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.igorcardoso.myroute.entitys.ServiceMonth;

public interface IServiceMonthRepository extends JpaRepository<ServiceMonth, UUID> {
    
}