package br.dev.igorcardoso.myroute.useCases.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.dev.igorcardoso.myroute.repositories.IUserRepository;

@Service
public class AuthenticationUseCase implements UserDetailsService {

  @Autowired
  private IUserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    return this.userRepository.findOneByEmail(email);
  }

}
