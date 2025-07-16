package lt.codeacademy.spring2025.eshop.common.exception;

import lombok.Getter;

@Getter
public abstract class EshopNotFoundException extends RuntimeException {

  private final String message;

  public EshopNotFoundException(String message) {
    this.message = message;
  }

}
