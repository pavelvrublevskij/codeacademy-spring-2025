package lt.codeacademy.spring2025.eshop.cart.service;

import java.util.UUID;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.core.domain.Product;
import lt.codeacademy.spring2025.eshop.core.domain.cart.Cart;
import lt.codeacademy.spring2025.eshop.core.domain.cart.CartItem;
import lt.codeacademy.spring2025.eshop.product.service.ProductService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {

  private final ProductService productService;

  public Cart addProductToCart(final UUID productId, final Cart cart) {
    final Product productById = productService.getProductById(productId);
    final CartItem cartItem = CartItem.builder()
      .product(productById)
      .quantity(1)
      .build();
    cart.addItem(cartItem);

    return cart;
  }
}
