package br.dev.igorcardoso.myroute.useCases.serviceMonthUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.igorcardoso.myroute.useCases.serviceMonthUseCase.DTOs.CreateServiceMonthDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/services-month")
public class ServiceMonthController {

  @Autowired
  CreateServiceMonthUseCase createServiceMonthUseCase;

  @PostMapping
  public void create(@RequestBody @Valid CreateServiceMonthDTO body) {
    this.createServiceMonthUseCase.execute(body);
  }
}
