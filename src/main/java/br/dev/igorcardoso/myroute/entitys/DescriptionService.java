package br.dev.igorcardoso.myroute.entitys;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import br.dev.igorcardoso.myroute.useCases.descriptionServiceUseCase.DTOs.CreateDescriptionServiceDTO;
import br.dev.igorcardoso.myroute.useCases.descriptionServiceUseCase.DTOs.UpdateDescriptionServiceDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name = "description_services")
@NoArgsConstructor
@AllArgsConstructor
@Data 
public class DescriptionService {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String description;

    @Column(name = "service_day_id")
    private UUID serviceDayId;

    @Column(name = "order_number")
    private Integer orderNumber;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    public DescriptionService(CreateDescriptionServiceDTO createDescriptionServiceDTO) {
        this.serviceDayId = createDescriptionServiceDTO.serviceDayId();
        this.description = createDescriptionServiceDTO.description();
    }

    public DescriptionService(UpdateDescriptionServiceDTO updateDescriptionServiceDTO) {
        this.description = updateDescriptionServiceDTO.description();
        // this.id = updateDescriptionServiceDTO.id();
    }
}
