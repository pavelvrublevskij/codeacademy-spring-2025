package lt.codeacademy.spring2025.eshop.product.mapper;

import org.springframework.stereotype.Component;
import lt.codeacademy.spring2025.eshop.common.mapper.DomainDtoMapper;
import lt.codeacademy.spring2025.eshop.core.domain.ProductCategory;
import lt.codeacademy.spring2025.eshop.product.dto.ProductCategoryDto;

@Component
public class ProductCategoryDtoMapper implements DomainDtoMapper<ProductCategory, ProductCategoryDto> {

  @Override
  public ProductCategoryDto toDto(ProductCategory domain) {
    return ProductCategoryDto.builder()
      .id(domain.getId())
      .name(domain.getName())
      .build();
  }

  @Override
  public ProductCategory toDomain(ProductCategoryDto productCategoryDto) {
    // TODO: implement this method when needed
    return null;
  }
}
