package br.dev.igorcardoso.myroute.useCases.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.igorcardoso.myroute.configs.security.TokenService;
import br.dev.igorcardoso.myroute.entitys.User;
import br.dev.igorcardoso.myroute.useCases.authentication.DTOs.AuthenticationDTO;
import br.dev.igorcardoso.myroute.useCases.authentication.DTOs.AuthenticationResponseDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private TokenService tokenService;

  @PostMapping
  public ResponseEntity<AuthenticationResponseDTO> handle(@RequestBody @Valid AuthenticationDTO authenticationDTO) {
    var usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
        authenticationDTO.email(), authenticationDTO.password());

    var authentication = this.authenticationManager.authenticate(
        usernamePasswordAuthenticationToken);

    String token = tokenService.createToken((User) authentication.getPrincipal());

    AuthenticationResponseDTO authenticationResponseDTO = new AuthenticationResponseDTO(token);

    return ResponseEntity.ok(authenticationResponseDTO);
  }
}
