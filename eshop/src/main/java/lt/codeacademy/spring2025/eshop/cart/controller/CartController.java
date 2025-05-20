package lt.codeacademy.spring2025.eshop.cart.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.Builder;

import static lt.codeacademy.spring2025.eshop.cart.controller.CartController.CART_SESSION;

@Controller
@RequestMapping("/cart")
@SessionAttributes(CART_SESSION)
public class CartController {

  protected static final String CART_SESSION = "cartSession";

  @ModelAttribute(CART_SESSION)
  public List<CartProductDto> createDefaultCartSession() {
    return List.of(CartProductDto.builder()
      .name("Testas")
      .unitPrice(BigDecimal.TEN)
      .amount(1)
      .build());
  }

  @GetMapping
  public String openCart() {
    return "cart/cart";
  }

  @Builder
  public record CartProductDto(
    String name,
    BigDecimal unitPrice,
    int amount) {
  }
}
