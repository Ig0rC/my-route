package br.dev.igorcardoso.myroute.useCases.userUseCase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.igorcardoso.myroute.entitys.User;
import br.dev.igorcardoso.myroute.repositories.IUserRepository;

@Service
public class ListUserUseCase {

  @Autowired
  private IUserRepository userRepository;

  public List<User> execute() {
    return this.userRepository.findAll();
  }
}
