package br.dev.igorcardoso.myroute.entitys;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;


@Entity(name = "services_month")
public class ServiceMonth {
    @Id
    @GeneratedValue(generator = "UUID")
    private String id;
    @Column(name = "date_month", nullable = false)
    private LocalDate dateMonth;
    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @Column(name = "created_at")
    @CreationTimestamp
    private String createdAt;
}
