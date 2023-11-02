package br.dev.igorcardoso.myroute.errors;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
  public ResponseEntity<
    List<MethodArgumentNotValidExceptionDTO>
  > handleMethodAgumentNotValidException(
    MethodArgumentNotValidException error
  ) {
    List<FieldError> fieldErrors = error.getFieldErrors();

    var body = fieldErrors.stream().map(MethodArgumentNotValidExceptionDTO::new).toList();

    return ResponseEntity
        .badRequest()
        .body(body);
  }
}
