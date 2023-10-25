package br.dev.igorcardoso.myroute.useCases.serviceDayUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.igorcardoso.myroute.useCases.serviceDayUseCase.DTOs.CreateServiceDayDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/services-day")
public class ServiceDayController {
    

    @Autowired
    private CreateServiceDayUseCase createServiceDayUseCase;

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid CreateServiceDayDTO body) {
        System.out.println(body);
        this.createServiceDayUseCase.execute(body);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
