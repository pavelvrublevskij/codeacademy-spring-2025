package lt.codeacademy.spring2025.eshop.product.mapper;

import org.springframework.stereotype.Component;
import lt.codeacademy.spring2025.eshop.core.domain.ProductCategory;
import lt.codeacademy.spring2025.eshop.product.model.ProductCategoryEntity;

@Component
public class ProductCategoryEntityMapper {

  public ProductCategory toProductCategory(final ProductCategoryEntity productCategoryEntity) {
    return ProductCategory.builder()
      .id(productCategoryEntity.getId())
      .name(productCategoryEntity.getName())
      .build();
  }
}
