package br.dev.igorcardoso.myroute.entitys;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import br.dev.igorcardoso.myroute.useCases.carUseCase.DTOs.CreateCarDTO;

@Entity(name = "cars")
@Data
public class Car {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(nullable = false, length = 180)
    private String plate;

    @Column(nullable = false, length = 4)
    private String year;

    @Column(nullable = false, length = 180)
    private String mark;

    @Column(nullable = false, length = 180)
    private String model;

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "created_at")
    @CreationTimestamp
    private String createdAt;

    public Car(CreateCarDTO carDTO) {
        this.plate = carDTO.plate();
        this.mark = carDTO.mark();
        this.model = carDTO.model();
        this.year = carDTO.year();
        this.userId = carDTO.userId();
    }
}
