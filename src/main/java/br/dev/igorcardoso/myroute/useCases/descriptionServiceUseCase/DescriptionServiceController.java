package br.dev.igorcardoso.myroute.useCases.descriptionServiceUseCase;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.dev.igorcardoso.myroute.entitys.DescriptionService;
import br.dev.igorcardoso.myroute.useCases.descriptionServiceUseCase.DTOs.CreateDescriptionServiceDTO;
import br.dev.igorcardoso.myroute.useCases.descriptionServiceUseCase.DTOs.UpdateDescriptionServiceDTO;
import br.dev.igorcardoso.myroute.useCases.descriptionServiceUseCase.DTOs.UpdateOrderNumberDescriptionServiceDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/description-service")
public class DescriptionServiceController {
    

    @Autowired
    private CreateDescriptionServiceUseCase createDescriptionServiceUseCase;
    @Autowired
    private ListDescriptionServiceUseCase ListDescriptionServiceUseCase;
    @Autowired
    private UpdateOrderNumberDescriptionServiceUseCase updateOrderNumberDescriptionServiceUseCase;
    @Autowired
    private UpdateDescriptionServiceUseCase updateDescriptionServiceUseCase;

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid CreateDescriptionServiceDTO body) {
        this.createDescriptionServiceUseCase.execute(body);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity list(@RequestParam(name = "serviceDayId") UUID serviceDayId) {
        List<DescriptionService> descriptionsService = this.ListDescriptionServiceUseCase
            .execute(
                serviceDayId
            );

        return ResponseEntity.status(HttpStatus.OK).body(descriptionsService);
    }

    @PutMapping("/update-order-number")
    public ResponseEntity updateOrderNumber(@RequestBody UpdateOrderNumberDescriptionServiceDTO body) throws Exception {
        this.updateOrderNumberDescriptionServiceUseCase
            .execute(body);

        return ResponseEntity.status(HttpStatus.OK).body("Atualizado com sucesso!");
    }

    @PutMapping
    public ResponseEntity update(@RequestBody UpdateDescriptionServiceDTO body) throws Exception {
        DescriptionService descriptionService = this.updateDescriptionServiceUseCase
            .execute(body);

        return ResponseEntity.status(HttpStatus.OK).body(descriptionService);
    }
}
