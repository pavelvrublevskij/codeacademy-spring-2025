package lt.codeacademy.spring2025.eshop.cart.mapper;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.cart.dto.CartProductDto;
import lt.codeacademy.spring2025.eshop.common.mapper.DomainDtoMapper;
import lt.codeacademy.spring2025.core.domain.Product;
import lt.codeacademy.spring2025.core.domain.cart.CartItem;
import lt.codeacademy.spring2025.core.domain.cart.calculator.CartItemCalculator;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CartItemMapper implements DomainDtoMapper<CartItem, CartProductDto> {

  private final CartItemCalculator cartItemCalculator;

  @Override
  public CartProductDto toDto(CartItem domain) {
    return CartProductDto.builder()
      .uuid(domain.getProduct().getId())
      .name(domain.getProduct().getName())
      .unitPrice(domain.getProduct().getPrice())
      .quantity(domain.getQuantity())
      .totalPrice(cartItemCalculator.calculateTotal(domain))
      .build();
  }

  @Override
  public CartItem toDomain(CartProductDto cartProductDto) {
    return CartItem.builder()
      .product(Product.builder()
        .id(cartProductDto.uuid())
        .name(cartProductDto.name())
        .price(cartProductDto.unitPrice())
        .build())
      .quantity(cartProductDto.quantity())
      .build();
  }
}
