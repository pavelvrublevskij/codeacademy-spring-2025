package lt.codeacademy.spring2025.eshop.product.mapper;

import org.springframework.stereotype.Component;
import lt.codeacademy.spring2025.eshop.product.dto.ProductDto;
import lt.codeacademy.spring2025.eshop.product.model.ProductEntity;

@Component
public final class ProductMapper {

	public ProductEntity toProductEntity(final ProductDto productDto) {
		return ProductEntity.builder()
				.name(productDto.getName())
				.price(productDto.getPrice())
				.amountInStock(productDto.getAmount())
				.build();
	}

	public ProductDto toProductDto(final ProductEntity productEntity) {
		return ProductDto.builder()
				.name(productEntity.getName())
				.price(productEntity.getPrice())
				.amount(productEntity.getAmountInStock())
				.build();
	}
}
