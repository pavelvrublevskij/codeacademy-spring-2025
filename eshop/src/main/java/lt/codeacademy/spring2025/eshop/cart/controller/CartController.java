package lt.codeacademy.spring2025.eshop.cart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import static lt.codeacademy.spring2025.eshop.cart.controller.CartController.CART_SESSION;

@Controller
@RequestMapping("/cart")
@SessionAttributes(CART_SESSION)
public class CartController {

  protected static final String CART_SESSION = "cartSession";

  @ModelAttribute(CART_SESSION)
  public String createDefaultCartSession() {
    return "Labas";
  }

  @GetMapping
  public String openCart() {
    return "cart/cart";
  }
}
