package lt.codeacademy.spring2025.eshop.api.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import lt.codeacademy.spring2025.eshop.api.dto.ErrorResponseDto;

@RestControllerAdvice
public class ApiExceptionHandlerAdvice {

  @ExceptionHandler(MaxUploadSizeExceededException.class)
  @ResponseStatus(HttpStatus.PAYLOAD_TOO_LARGE)
  public ErrorResponseDto handleFileToLarge(MaxUploadSizeExceededException ex) {
    return ErrorResponseDto.builder()
        .errorMessage(ex.getMessage())
        .errorCode(HttpStatus.PAYLOAD_TOO_LARGE.value())
        .build();
  }
}
