package lt.codeacademy.spring2025.eshop.product.mapper;

import org.springframework.stereotype.Component;
import lt.codeacademy.spring2025.eshop.core.domain.Product;
import lt.codeacademy.spring2025.eshop.product.dto.ProductDto;

@Component
public final class ProductDtoMapper {

	public Product toProduct(final ProductDto productDto) {
		return Product.builder()
				.name(productDto.getName())
				.price(productDto.getPrice())
				.amount(productDto.getAmount())
				.build();
	}

	public ProductDto toProductDto(final Product Product) {
		return ProductDto.builder()
				.name(Product.getName())
				.price(Product.getPrice())
				.amount(Product.getAmount())
				.build();
	}
}
