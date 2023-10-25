package br.dev.igorcardoso.myroute.entitys;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import br.dev.igorcardoso.myroute.useCases.serviceDayUseCase.DTOs.CreateServiceDayDTO;

import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "services_day")
@Data
public class ServiceDay {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    @Column(name = "service_date", nullable = false)
    private LocalDate serviceDate;
    @Column(name = "departure_time", nullable = false, length = 5)
    private String departureTime;
    @Column(name = "arrival_time", nullable = false, length = 5)
    private String arrivalTime;
    @Column(name = "departure_odometer", nullable = false)
    private Integer departureOdometer;
    @Column(name = "arrival_odometer", nullable = false)
    private Integer arrivalOdometer;
    @Column(name = "service_month_id", nullable = false)
    private UUID serviceMonthId;
    @Column(name = "created_at")
    @CreationTimestamp
    private String createdAt;

    public ServiceDay(CreateServiceDayDTO createServiceDayDTO) {
        this.arrivalOdometer = createServiceDayDTO.arrivalOdometer();
        this.departureOdometer = createServiceDayDTO.departureOdometer();
        this.arrivalTime = createServiceDayDTO.arrivalTime();
        this.departureTime = createServiceDayDTO.departureTime();
        this.serviceMonthId = createServiceDayDTO.serviceMonthId();
        this.serviceDate = createServiceDayDTO.serviceDate();
    }
}
