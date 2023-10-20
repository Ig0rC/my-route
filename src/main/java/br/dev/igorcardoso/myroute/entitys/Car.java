package br.dev.igorcardoso.myroute.entitys;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity(name = "cars")
@Data
public class Car {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    @Column(nullable = false)
    private String plate;
    @Column(nullable = false)
    private String mark;
    @Column(nullable = false)
    private String model;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
