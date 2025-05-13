package lt.codeacademy.spring2025.eshop.product.mapper;

import org.springframework.stereotype.Component;
import lt.codeacademy.spring2025.eshop.core.domain.Product;
import lt.codeacademy.spring2025.eshop.product.dto.ProductDto;

@Component
public final class ProductDtoMapper {

	public Product toProduct(final ProductDto productDto) {
		return Product.builder()
        .id(productDto.getId())
				.name(productDto.getName())
				.price(productDto.getPrice())
				.amount(productDto.getAmount())
        .description(productDto.getDescription())
        .categoryId(productDto.getCategoryId())
				.build();
	}

	public ProductDto toProductDto(final Product product) {
		return ProductDto.builder()
        .id(product.getId())
				.name(product.getName())
				.price(product.getPrice())
				.amount(product.getAmount())
        .description(product.getDescription())
				.build();
	}
}
