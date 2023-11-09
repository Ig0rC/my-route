package br.dev.igorcardoso.myroute.configs.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import br.dev.igorcardoso.myroute.entitys.User;

@Service
public class TokenService {

  @Value("${api.security.key.token}")
  private String keyScret;

  public String createToken(User user) {
    try {
      System.out.println(keyScret);
      var algorithms = Algorithm.HMAC256(keyScret);

      return JWT.create()
          .withIssuer("API MyRoute")
          .withClaim("email", user.getEmail())
          .withClaim("id", user.getId().toString())
          .sign(algorithms);

    } catch (JWTCreationException exception) {
      throw new RuntimeException("erro ao gerrar token jwt", exception);
    }
  }

  public DecodedJWT veriferToken(String token) {
    try {
      var algorithms = Algorithm.HMAC256(keyScret);

      JWTVerifier verifier = JWT
          .require(algorithms)
          .build();

      DecodedJWT jwt = verifier.verify(token);

      return jwt;
    } catch (JWTCreationException exception) {
      throw new RuntimeException("erro ao gerrar token jwt", exception);
    }
  }
}
