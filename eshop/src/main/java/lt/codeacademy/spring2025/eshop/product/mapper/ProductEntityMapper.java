package lt.codeacademy.spring2025.eshop.product.mapper;

import java.util.HashSet;

import org.springframework.stereotype.Component;
import lt.codeacademy.spring2025.eshop.core.domain.Product;
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
				.build();
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
