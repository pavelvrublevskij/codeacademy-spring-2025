package lt.codeacademy.spring2025.eshop.cart.mapper;

import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.cart.dto.CartDto;
import lt.codeacademy.spring2025.eshop.common.mapper.DomainDtoMapper;
import lt.codeacademy.spring2025.core.domain.cart.Cart;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CartMapper implements DomainDtoMapper<Cart, CartDto> {

  private final CartItemMapper cartItemMapper;

  @Override
  public CartDto toDto(Cart domain) {
    return CartDto.builder()
      .cartItems(domain.getItems().stream()
        .map(cartItemMapper::toDto)
        .toList())  // this toList is unmodifiable
      .build();
  }

  @Override
  public Cart toDomain(CartDto cartDto) {
    return Cart.builder()
      .items(cartDto.getCartItems().stream()
        .map(cartItemMapper::toDomain)
        .collect(Collectors.toList()))  // this is modifiable list
      .build();
  }
}
