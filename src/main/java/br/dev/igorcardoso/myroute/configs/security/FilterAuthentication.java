package br.dev.igorcardoso.myroute.configs.security;

import java.io.IOException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.dev.igorcardoso.myroute.entitys.User;
import br.dev.igorcardoso.myroute.repositories.IUserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
class FilterAuthentication extends OncePerRequestFilter {

  private TokenService tokenService;
  private IUserRepository userRepository;

  public FilterAuthentication(TokenService tokenService, IUserRepository userRepository) {
    this.tokenService = tokenService;
    this.userRepository = userRepository;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    var serveletPath = request.getServletPath();

    if (serveletPath.startsWith("/authentication")) {
      System.out.println("authentication");
      filterChain.doFilter(request, response);
    } else {
      var authorization = request.getHeader("Authorization");
      System.out.println(authorization);

      if (authorization == null) {
        throw new RuntimeException("Não autorizado!");
      }

      var separetedBearer = authorization.split(" ");

      if (separetedBearer.length < 2) {
        throw new RuntimeException("Token não enviado!");
      }

      var token = separetedBearer[1];

      var verifiedToken = this.tokenService.veriferToken(token);

      String email = verifiedToken.getClaim("email").asString();

      User user = this.userRepository.findByEmail(email);

      if (user == null) {
        throw new RuntimeException("Usuário não encontrado!");
      }

      var authenticationUser = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

      SecurityContextHolder.getContext().setAuthentication(authenticationUser);

      // var userId = (UUID) verifiedToken.getClaim("id").asString();

      request.setAttribute("email", email);
      request.setAttribute("userId", verifiedToken.getClaim("id").asString());

      filterChain.doFilter(request, response);
    }
  }
}
