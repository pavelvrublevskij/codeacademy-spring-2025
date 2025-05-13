package lt.codeacademy.spring2025.eshop.product.mapper;

import org.springframework.stereotype.Component;
import lt.codeacademy.spring2025.eshop.core.domain.Product;
import lt.codeacademy.spring2025.eshop.core.domain.ProductCategory;
import lt.codeacademy.spring2025.eshop.product.dto.ProductListDto;

@Component
public class ProductListDtoMapper {

  public ProductListDto toProductListDto(final Product product) {
    return ProductListDto.builder()
      .uuid(product.getId())
      .name(product.getName())
      .price(product.getPrice())
      .amount(product.getAmount())
      .description(product.getDescription())
      .categoryName(product.getCategories().stream()
        .map(ProductCategory::getName)
        .reduce((first, second) -> first + ", " + second)
        .orElse(""))
      .build();
  }
}
