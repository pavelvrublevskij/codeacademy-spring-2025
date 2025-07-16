package lt.codeacademy.spring2025.eshop.core.domain.cart;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Cart {

  @Builder.Default
  private List<CartItem> items = new ArrayList<>();

  public void addItem(final CartItem cartItem) {
    items.add(cartItem);
  }
}
