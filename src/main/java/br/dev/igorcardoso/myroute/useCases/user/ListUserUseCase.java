package br.dev.igorcardoso.myroute.useCases.user;

import java.util.List;

import org.springframework.stereotype.Service;

import br.dev.igorcardoso.myroute.entitys.User;
import br.dev.igorcardoso.myroute.repositories.IUserRepository;

@Service
public class ListUserUseCase {

  private IUserRepository userRepository;

  public ListUserUseCase(IUserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> execute() {
    return this.userRepository.findAll();
  }
}
