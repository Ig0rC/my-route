package br.dev.igorcardoso.myroute.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import br.dev.igorcardoso.myroute.useCases.serviceMonthUseCase.DTOs.CreateServiceMonthDTO;

import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "services_month")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceMonth {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "date_month", nullable = false)
    private LocalDate dateMonth;

    // @ManyToOne
    @Column(name = "car_id")
    private UUID carId;

    @Column(name = "created_at")
    @CreationTimestamp
    private String createdAt;

    public ServiceMonth(CreateServiceMonthDTO createServiceMonthDTO) {
        this.dateMonth = createServiceMonthDTO.dateMonth();
        this.carId = createServiceMonthDTO.carId();
    }
}
