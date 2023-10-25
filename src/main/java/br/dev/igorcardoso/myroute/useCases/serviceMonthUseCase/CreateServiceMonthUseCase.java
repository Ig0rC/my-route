package br.dev.igorcardoso.myroute.useCases.serviceMonthUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.igorcardoso.myroute.entitys.ServiceMonth;

import br.dev.igorcardoso.myroute.useCases.serviceMonthUseCase.DTOs.CreateServiceMonthDTO;

@Service
public class CreateServiceMonthUseCase {
    
    @Autowired
    public IServiceMonthRepository serviceMonthRepository;

    public void execute(CreateServiceMonthDTO  serviceMonthDTO) {
        ServiceMonth serviceMonthCreated =  new ServiceMonth(serviceMonthDTO);
        this.serviceMonthRepository.save(serviceMonthCreated);
    }
}
