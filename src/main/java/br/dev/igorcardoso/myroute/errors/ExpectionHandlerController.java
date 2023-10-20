package br.dev.igorcardoso.myroute.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.dev.igorcardoso.myroute.errors.DTOs.ExpectionDTO;

@ControllerAdvice
public class ExpectionHandlerController {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ExpectionDTO> handleException(Exception e) {
    ExpectionDTO expectionDTO = new ExpectionDTO(e.getMessage(), 400);

    return ResponseEntity
        .badRequest()
        .body(expectionDTO);
  }
}
