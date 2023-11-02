package br.dev.igorcardoso.myroute.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.igorcardoso.myroute.entitys.User;

public interface IUserRepository extends JpaRepository<User, UUID> {
  User findByEmail(String email);
}
