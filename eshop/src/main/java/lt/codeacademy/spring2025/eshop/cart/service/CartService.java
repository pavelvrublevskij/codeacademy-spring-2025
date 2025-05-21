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
}
