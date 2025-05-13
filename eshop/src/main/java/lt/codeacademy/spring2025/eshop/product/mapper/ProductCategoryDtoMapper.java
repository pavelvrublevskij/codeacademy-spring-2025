package lt.codeacademy.spring2025.eshop.product.mapper;

import org.springframework.stereotype.Component;
import lt.codeacademy.spring2025.eshop.core.domain.ProductCategory;
import lt.codeacademy.spring2025.eshop.product.dto.ProductCategoryDto;

@Component
public class ProductCategoryDtoMapper {

  public ProductCategoryDto toProductCategoryDto(final ProductCategory productCategory) {
    return ProductCategoryDto.builder()
      .id(productCategory.getId())
      .name(productCategory.getName())
      .build();
  }
}
