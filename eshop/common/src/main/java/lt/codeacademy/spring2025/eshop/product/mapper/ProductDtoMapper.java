package lt.codeacademy.spring2025.eshop.product.mapper;

import java.util.Set;

import org.springframework.stereotype.Component;
import lt.codeacademy.spring2025.eshop.common.mapper.DomainDtoMapper;
import lt.codeacademy.spring2025.core.domain.Product;
import lt.codeacademy.spring2025.core.domain.ProductCategory;
import lt.codeacademy.spring2025.eshop.product.dto.ProductDto;

@Component
public final class ProductDtoMapper implements DomainDtoMapper<Product, ProductDto> {

  @Override
  public ProductDto toDto(Product domain) {
    return ProductDto.builder()
      .id(domain.getId())
      .name(domain.getName())
      .price(domain.getPrice())
      .amount(domain.getAmount())
      .description(domain.getDescription())
      .build();
  }

  @Override
  public Product toDomain(ProductDto productDto) {
    return Product.builder()
      .id(productDto.getId())
      .name(productDto.getName())
      .price(productDto.getPrice())
      .amount(productDto.getAmount())
      .description(productDto.getDescription())
      .categories(Set.of(ProductCategory.builder()
        .id(productDto.getCategoryId())
        .build()))
      .build();
  }
}
