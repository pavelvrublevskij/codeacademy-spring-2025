package lt.codeacademy.spring2025.eshop.product.mapper;

import org.springframework.stereotype.Component;
import lt.codeacademy.spring2025.eshop.core.domain.Product;
import lt.codeacademy.spring2025.eshop.product.model.ProductEntity;

@Component
public class ProductEntityMapper {

	public Product toProduct(final ProductEntity productEntity) {
		return Product.builder()
				.name(productEntity.getName())
				.price(productEntity.getPrice())
				.amount(productEntity.getAmountInStock())
				.build();
	}

	public ProductEntity toProductEntity(final Product product) {
		return ProductEntity.builder()
				.name(product.getName())
				.price(product.getPrice())
				.amountInStock(product.getAmount())
				.build();
	}
}
