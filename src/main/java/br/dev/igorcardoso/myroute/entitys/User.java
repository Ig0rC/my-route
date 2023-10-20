package br.dev.igorcardoso.myroute.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.CreationTimestamp;

import br.dev.igorcardoso.myroute.useCases.userUseCase.DTOs.CreateUserDTO;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(unique = true, nullable = false, length = 180)
    private String email;

    @Column(nullable = false, length = 180)
    private String password;


    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    public User(CreateUserDTO user) {
        this.email =  user.email();
        this.password = user.password();
    }
}
