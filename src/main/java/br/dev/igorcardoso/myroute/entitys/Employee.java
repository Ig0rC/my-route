package br.dev.igorcardoso.myroute.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.CreationTimestamp;

import br.dev.igorcardoso.myroute.useCases.employeeUseCase.DTOs.CreateEmployeeDTO;

import java.util.UUID;

@Entity(name = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
  @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;
  @Column(name = "full_name", nullable = false, length = 180)
  private String fullName;
  @Column(length = 180)
  private String position;
  @Column(length = 180)
  private String registration;
  @Column(name = "lot_number", length = 180)
  private String lotNumber;

  @OneToOne()
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @Column(name = "created_at")
  @CreationTimestamp
  private String createdAt;

  public Employee(CreateEmployeeDTO employeeDTO) {
    this.fullName = employeeDTO.fullName();
    this.position = employeeDTO.position();
    this.registration = employeeDTO.registration();
    this.lotNumber = employeeDTO.lotNumber();
  }

}
