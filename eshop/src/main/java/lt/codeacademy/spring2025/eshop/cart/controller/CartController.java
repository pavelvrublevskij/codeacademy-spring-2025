package lt.codeacademy.spring2025.eshop.cart.controller;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.cart.dto.CartDto;
import lt.codeacademy.spring2025.eshop.cart.dto.CartProductDto;
import lt.codeacademy.spring2025.eshop.cart.mapper.CartProductDtoMapper;
import lt.codeacademy.spring2025.eshop.product.service.ProductService;

import static lt.codeacademy.spring2025.eshop.HttpEndpoint.CART;
import static lt.codeacademy.spring2025.eshop.HttpEndpoint.CART_ADD;
import static lt.codeacademy.spring2025.eshop.cart.controller.CartController.CART_SESSION;

@Controller
@SessionAttributes(CART_SESSION)
@RequiredArgsConstructor
public class CartController {

  protected static final String CART_SESSION = "cartSession";

  private final ProductService productService;
  private final CartProductDtoMapper cartProductDtoMapper;

  @ModelAttribute(CART_SESSION)
  public CartDto createDefaultCartSession() {
    return CartDto.builder().build();
  }

  @GetMapping(CART)
  public String openCart() {
    return "cart/cart";
  }

  @PostMapping(CART_ADD)
  public String addToCart(@PathVariable UUID productId,
                          @ModelAttribute(CART_SESSION) CartDto cartSession) {
    final CartProductDto cartProductDto = cartProductDtoMapper.toDto(productService.getProductById(productId));
    cartSession.addItem(cartProductDto);
    return "redirect:/products";
  }
}
