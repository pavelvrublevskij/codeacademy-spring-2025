package lt.codeacademy.spring2025.eshop.api.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import lt.codeacademy.spring2025.eshop.api.dto.ErrorResponseDto;
import lt.codeacademy.spring2025.eshop.api.exception.InternalServerErrorException;

@RestControllerAdvice
public class ApplicationRestControllerAdvice {

  @ExceptionHandler
  public ResponseEntity<ErrorResponseDto> internalServerError(InternalServerErrorException e) {
    return ResponseEntity
      .status(HttpStatus.INTERNAL_SERVER_ERROR)
      .body(new ErrorResponseDto(
        HttpStatus.INTERNAL_SERVER_ERROR.value(),
        e.getMessage()
      ));
  }
}
