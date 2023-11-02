package br.dev.igorcardoso.myroute.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.igorcardoso.myroute.entitys.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, UUID> {

}
