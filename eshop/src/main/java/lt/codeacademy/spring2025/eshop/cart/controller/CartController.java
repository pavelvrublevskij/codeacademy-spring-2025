package lt.codeacademy.spring2025.eshop.cart.controller;

import java.util.UUID;

import static lt.codeacademy.spring2025.eshop.HttpEndpoint.CART;
import static lt.codeacademy.spring2025.eshop.HttpEndpoint.CART_ADD;
import static lt.codeacademy.spring2025.eshop.cart.controller.CartController.CART_SESSION;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.cart.dto.CartDto;
import lt.codeacademy.spring2025.eshop.cart.mapper.CartMapper;
import lt.codeacademy.spring2025.eshop.cart.service.CartService;
import lt.codeacademy.spring2025.eshop.core.domain.cart.Cart;
import lt.codeacademy.spring2025.eshop.helper.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@SessionAttributes(CART_SESSION)
@RequiredArgsConstructor
public class CartController {

  protected static final String CART_SESSION = "cartSession";

  private final CartService cartService;
  private final CartMapper cartMapper;
  private final MessageService messageService;

  @ModelAttribute(CART_SESSION)
  public CartDto createDefaultCartSession() {
    return CartDto.builder().build();
  }

  @GetMapping(CART)
  public String openCart(HttpServletRequest request) {
    return "cart/cart";
  }

  @PostMapping(CART_ADD)
  public String addToCart(@PathVariable UUID productId,
                          @ModelAttribute(CART_SESSION) CartDto cartSession,
                          Model model) {
    final Cart sessionData = cartMapper.toDomain(cartSession);
    final Cart cart = cartService.addProductToCartByProductUUID(productId, sessionData);
    final CartDto cartDto = cartMapper.toDto(cart);
    model.addAttribute(CART_SESSION, cartDto);

    return "redirect:/products";
  }

  @PostMapping(CART)
  public RedirectView order(RedirectAttributes redirectAttributes, SessionStatus sessionStatus) {
    try {
      // TODO: implement order, save to DB, send email etc.

      // close and clear session
      sessionStatus.setComplete();

      redirectAttributes.addFlashAttribute("messageSuccess",
        messageService.getTranslatedMessage("order.message.success"));
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("messageError",
        messageService.getTranslatedMessage("order.message.error"));
    }

    return new RedirectView(CART);
  }
}
