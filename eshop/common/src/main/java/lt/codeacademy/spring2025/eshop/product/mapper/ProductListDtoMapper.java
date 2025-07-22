package lt.codeacademy.spring2025.eshop.product.mapper;

import org.springframework.stereotype.Component;
import lt.codeacademy.spring2025.eshop.common.mapper.DomainDtoMapper;
import lt.codeacademy.spring2025.core.domain.Product;
import lt.codeacademy.spring2025.core.domain.ProductCategory;
import lt.codeacademy.spring2025.eshop.product.dto.ProductListDto;

@Component
public class ProductListDtoMapper implements DomainDtoMapper<Product, ProductListDto> {

  @Override
  public ProductListDto toDto(Product domain) {
    return ProductListDto.builder()
      .uuid(domain.getId())
      .name(domain.getName())
      .price(domain.getPrice())
      .amount(domain.getAmount())
      .description(domain.getDescription())
      .categoryName(domain.getCategories().stream()
        .map(ProductCategory::getName)
        .reduce((first, second) -> first + ", " + second)
        .orElse(""))
      .build();
  }

  @Override
  public Product toDomain(ProductListDto productListDto) {
    // TODO: implement this method when needed
    return null;
  }
}
