package lt.codeacademy.spring2025.eshop.cart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.servlet.http.HttpServletRequest;

import static lt.codeacademy.spring2025.eshop.cart.controller.CartController.CART_SESSION;

@Controller
@RequestMapping("/cart")
@SessionAttributes(CART_SESSION)
public class CartController {

  protected static final String CART_SESSION = "cartSession";

  @GetMapping
  public String openCart(Model model, HttpServletRequest request) {
    model.addAttribute("cartSessionValue", request.getSession().getAttribute(CART_SESSION));
    return "cart/cart";
  }

  @GetMapping("/add")
  public String addToCart(Model model) {
    model.addAttribute(CART_SESSION, "Labas");
    return "redirect:/cart";
  }
}
