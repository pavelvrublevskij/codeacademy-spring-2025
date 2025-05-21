package lt.codeacademy.spring2025.eshop.core.domain.cart;

import lombok.Builder;
import lombok.Getter;
import lt.codeacademy.spring2025.eshop.core.domain.Product;

@Builder
@Getter
public class CartItem {

  private final Product product;
  private int quantity;

}
