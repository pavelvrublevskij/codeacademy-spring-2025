package lt.codeacademy.spring2025.eshop.cart.dto;

import java.math.BigDecimal;
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

  public int cartTotalQuantity() {
    return cartItems.stream()
      .mapToInt(CartProductDto::quantity)
      .sum();
  }

  public BigDecimal cartTotalPrice() {
    return cartItems.stream()
      .map(CartProductDto::totalPrice)
      .reduce(BigDecimal.ZERO, BigDecimal::add);
  }
}
