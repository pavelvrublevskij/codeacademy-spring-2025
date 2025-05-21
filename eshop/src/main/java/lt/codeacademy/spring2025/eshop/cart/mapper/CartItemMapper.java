package lt.codeacademy.spring2025.eshop.cart.mapper;

import lt.codeacademy.spring2025.eshop.cart.dto.CartProductDto;
import lt.codeacademy.spring2025.eshop.common.mapper.DomainDtoMapper;
import lt.codeacademy.spring2025.eshop.core.domain.Product;
import lt.codeacademy.spring2025.eshop.core.domain.cart.CartItem;
import org.springframework.stereotype.Component;

@Component
public class CartItemMapper implements DomainDtoMapper<CartItem, CartProductDto> {

  @Override
  public CartProductDto toDto(CartItem domain) {
    return CartProductDto.builder()
      .uuid(domain.getProduct().getId())
      .name(domain.getProduct().getName())
      .unitPrice(domain.getProduct().getPrice())
      .quantity(domain.getQuantity())
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
      .quantity(1)
      .build();
  }
}
