package br.dev.igorcardoso.myroute.errors;

import java.util.List;

import javax.naming.AuthenticationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.auth0.jwt.exceptions.JWTDecodeException;

import br.dev.igorcardoso.myroute.errors.DTOs.ExpectionDTO;
import br.dev.igorcardoso.myroute.errors.DTOs.MethodArgumentNotValidExceptionDTO;
import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ExpectionHandlerController {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ExpectionDTO> handleException(Exception error) {
    ExpectionDTO expectionDTO = new ExpectionDTO(error.getMessage(), 400);

    return ResponseEntity
        .badRequest()
        .body(expectionDTO);
  }

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<ExpectionDTO> handleEntityNotFoundExpection() {
    return ResponseEntity
        .notFound()
        .build();
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<List<MethodArgumentNotValidExceptionDTO>> handleMethodAgumentNotValidException(
      MethodArgumentNotValidException error) {
    List<FieldError> fieldErrors = error.getFieldErrors();

    var body = fieldErrors.stream().map(MethodArgumentNotValidExceptionDTO::new).toList();

    return ResponseEntity
        .badRequest()
        .body(body);
  }

  @ExceptionHandler(BadCredentialsException.class)
  public ResponseEntity handleBadCredentialsException() {
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
    return ResponseEntity.badRequest().body(ex.getMessage());
  }

  @ExceptionHandler(AuthenticationException.class)
  public ResponseEntity handleAuthenticationException() {
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Falha na autenticação");
  }

  @ExceptionHandler(AccessDeniedException.class)
  public ResponseEntity handleAccessDeniedException() {
    return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Acesso negado");
  }

  @ExceptionHandler(JWTDecodeException.class)
  public ResponseEntity handleJWTDecodeException() {
    return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Token inválido");
  }

}
