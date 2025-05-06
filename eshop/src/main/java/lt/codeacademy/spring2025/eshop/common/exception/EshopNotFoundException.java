package lt.codeacademy.spring2025.eshop.common.exception;

import lombok.Getter;

@Getter
public abstract class EshopNotFoundException extends RuntimeException {

  private static final String messageFormat = "%s not found!";
  private final String message;

  public EshopNotFoundException(String type) {
    this.message = String.format(messageFormat, type);
  }

}
