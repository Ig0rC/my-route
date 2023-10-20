package br.dev.igorcardoso.myroute.entitys;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "services_day")
@Data
public class ServiceDay {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    @Column(name = "service_date", nullable = false)
    private LocalDateTime serviceDate;
    @Column(name = "description_service", nullable = false)
    private String descriptionService;
    @Column(name = "departure_time", nullable = false, length = 5)
    private String departureTime;
    @Column(name = "arrival_time", nullable = false, length = 5)
    private String arrivalTime;
    @Column(name = "departure_odometer", nullable = false)
    private Integer departureOdometer;
    @Column(name = "arrival_odometer", nullable = false)
    private Integer arrivalOdometer;
    @ManyToOne
    @JoinColumn(name = "service_month_id", nullable = false)
    private ServiceMonth serviceMonth;
    @Column(name = "created_at")
    @CreationTimestamp
    private String createdAt;
}
