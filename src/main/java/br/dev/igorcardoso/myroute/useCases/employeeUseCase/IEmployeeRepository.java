package br.dev.igorcardoso.myroute.useCases.employeeUseCase;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.igorcardoso.myroute.entitys.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, UUID> {

}
