package lt.codeacademy.spring2025.eshop.product.mapper;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import lt.codeacademy.spring2025.eshop.core.domain.Product;
import lt.codeacademy.spring2025.eshop.core.domain.ProductCategory;
import lt.codeacademy.spring2025.eshop.product.model.ProductEntity;

@Component
public class ProductEntityMapper {

	public Product toProduct(final ProductEntity productEntity) {
		return Product.builder()
        .id(productEntity.getProductId())
				.name(productEntity.getName())
				.price(productEntity.getPrice())
				.amount(productEntity.getAmountInStock())
        .description(productEntity.getDescription())
        .categories(mapCategoriesFromEntity(productEntity))
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

  public ProductEntity toProductEntity(final Product product) {
		return ProductEntity.builder()
        .productId(product.getId())
				.name(product.getName())
				.price(product.getPrice())
				.amountInStock(product.getAmount())
        .description(product.getDescription())
        .productCategories(new HashSet<>())
				.build();
	}
}
