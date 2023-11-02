package br.dev.igorcardoso.myroute.useCases.serviceDayUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.igorcardoso.myroute.entitys.ServiceDay;
import br.dev.igorcardoso.myroute.useCases.serviceDayUseCase.DTOs.CreateServiceDayDTO;

@Service
public class CreateServiceDayUseCase {
    

    @Autowired
    private IServiceDayRepository serviceDayRepository;

    public void execute(CreateServiceDayDTO createServiceDayDTO) throws Exception {
        var isExistsServiceDate = this.serviceDayRepository.findByServiceDate(
            createServiceDayDTO.serviceDate()
        );

        if(isExistsServiceDate != null) {
            throw new Exception("Data de Serviço já criado.");
        }

        ServiceDay serviceDay = new ServiceDay(createServiceDayDTO);

        this.serviceDayRepository.save(serviceDay);
    }

}
