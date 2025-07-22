package lt.codeacademy.spring2025.eshop.product.mapper;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import lt.codeacademy.spring2025.eshop.common.mapper.DomainEntityMapper;
import lt.codeacademy.spring2025.core.domain.Product;
import lt.codeacademy.spring2025.core.domain.ProductCategory;
import lt.codeacademy.spring2025.eshop.product.model.ProductEntity;

@Component
public class ProductEntityMapper implements DomainEntityMapper<Product, ProductEntity> {

  @Override
  public ProductEntity toEntity(Product domain) {
    return ProductEntity.builder()
      .productId(domain.getId())
      .name(domain.getName())
      .price(domain.getPrice())
      .amountInStock(domain.getAmount())
      .description(domain.getDescription())
      .productCategories(new HashSet<>())
      .build();
  }

  @Override
  public Product toDomain(ProductEntity entity) {
    return Product.builder()
      .id(entity.getProductId())
      .name(entity.getName())
      .price(entity.getPrice())
      .amount(entity.getAmountInStock())
      .description(entity.getDescription())
      .categories(mapCategoriesFromEntity(entity))
      .build();
  }

  private Set<ProductCategory> mapCategoriesFromEntity(final ProductEntity productEntity) {
    return productEntity.getProductCategories().stream()
      .map(productCategoryEntity ->
        ProductCategory.builder()
          .id(productCategoryEntity.getId())
          .name(productCategoryEntity.getName())
          .build())
      .collect(Collectors.toSet());
  }
}
