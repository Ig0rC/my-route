package br.dev.igorcardoso.myroute.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity(name = "employees")
@Data
public class Employee {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    @Column(name = "full_name")
    private String fullName;
    private String position;
    private String registration;
    private String lost_number;
    private User user;
}
