package lt.codeacademy.spring2025.eshop.cart.service;

import java.util.UUID;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.cart.dto.OrderDto;
import lt.codeacademy.spring2025.core.domain.Product;
import lt.codeacademy.spring2025.core.domain.cart.Cart;
import lt.codeacademy.spring2025.core.domain.cart.CartItem;
import lt.codeacademy.spring2025.eshop.product.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CartService {

  private final ProductService productService;
  private final OrderService orderService;

  public Cart addProductToCartByProductUUID(final UUID productId, final Cart cart) {
    /**
     * This code checks if a product is already in the cart:
     * If it is, it increases its quantity.
     * If it isn't, it adds the product to the cart.
     *
     * It uses Java Streams and Optional.ifPresentOrElse for concise logic.
     */
    cart.getItems().stream()
      .filter(cartItem -> cartItem.getProduct().getId().equals(productId))
      .findFirst()
      .ifPresentOrElse(
        CartItem::increaseQuantity,
        () -> addProductToCart(productId, cart)
      );

    return cart;
  }

  private void addProductToCart(final UUID productId, final Cart cart) {
    final Product productById = productService.getProductById(productId);
    final CartItem cartItem = CartItem.builder()
      .product(productById)
      .build();
    cart.addItem(cartItem);
  }

  @Transactional
  public OrderDto processOrder(Cart cart) {
    return orderService.createOrder(cart);
  }
}
