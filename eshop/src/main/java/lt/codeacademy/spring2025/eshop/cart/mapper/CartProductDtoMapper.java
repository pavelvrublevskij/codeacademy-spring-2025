package lt.codeacademy.spring2025.eshop.cart.mapper;

import org.springframework.stereotype.Component;
import lt.codeacademy.spring2025.eshop.cart.dto.CartProductDto;
import lt.codeacademy.spring2025.eshop.common.mapper.DomainDtoMapper;
import lt.codeacademy.spring2025.eshop.core.domain.Product;

@Component
public class CartProductDtoMapper implements DomainDtoMapper<Product, CartProductDto> {

  @Override
  public CartProductDto toDto(Product product) {
    return CartProductDto.builder()
      .name(product.getName())
      .unitPrice(product.getPrice())
      .amount(1)
      .build();
  }

  @Override
  public Product toDomain(CartProductDto cartProductDto) {
    throw new UnsupportedOperationException("Not implemented yet");
  }
}
