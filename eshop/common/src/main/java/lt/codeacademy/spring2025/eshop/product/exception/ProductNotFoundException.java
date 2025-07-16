package lt.codeacademy.spring2025.eshop.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import lt.codeacademy.spring2025.eshop.common.exception.EshopNotFoundException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends EshopNotFoundException {

  public ProductNotFoundException(final String message) {
    super(message);
  }

}
