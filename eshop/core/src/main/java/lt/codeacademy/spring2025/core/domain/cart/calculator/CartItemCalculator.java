package lt.codeacademy.spring2025.core.domain.cart.calculator;

import java.math.BigDecimal;

import lt.codeacademy.spring2025.core.domain.cart.CartItem;
import org.springframework.stereotype.Component;

@Component
public class CartItemCalculator {

  public BigDecimal calculateTotal(final CartItem cartItem) {
    return cartItem.getProduct().getPrice().multiply(BigDecimal.valueOf(cartItem.getQuantity()));
  }
}
