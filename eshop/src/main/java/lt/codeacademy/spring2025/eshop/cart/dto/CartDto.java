package lt.codeacademy.spring2025.eshop.cart.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CartDto {

  @Builder.Default
  private final List<CartProductDto> cartItems = new ArrayList<>();

  public void addItem(final CartProductDto cartProductDto) {
    cartItems.add(cartProductDto);
  }
}
