package lt.codeacademy.spring2025.eshop.product.mapper;

import org.springframework.stereotype.Component;
import lt.codeacademy.spring2025.eshop.common.mapper.DomainEntityMapper;
import lt.codeacademy.spring2025.core.domain.ProductCategory;
import lt.codeacademy.spring2025.eshop.product.model.ProductCategoryEntity;

@Component
public class ProductCategoryEntityMapper implements DomainEntityMapper<ProductCategory, ProductCategoryEntity> {

  @Override
  public ProductCategoryEntity toEntity(ProductCategory domain) {
    // TODO: implement this method when needed
    return null;
  }

  @Override
  public ProductCategory toDomain(ProductCategoryEntity entity) {
    return ProductCategory.builder()
      .id(entity.getId())
      .name(entity.getName())
      .build();
  }
}
