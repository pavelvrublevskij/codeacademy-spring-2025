package lt.codeacademy.spring2025.core.domain.cart;

import lombok.Builder;
import lombok.Getter;
import lt.codeacademy.spring2025.core.domain.Product;

@Builder
@Getter
public class CartItem {

  private final Product product;
  @Builder.Default
  private int quantity = 1;

  public void increaseQuantity() {
    quantity++;
  }

}
