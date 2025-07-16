package lt.codeacademy.spring2025.eshop.product.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import lt.codeacademy.spring2025.eshop.core.domain.ProductCategory;
import lt.codeacademy.spring2025.eshop.product.model.ProductCategoryEntity;

class ProductCategoryEntityMapperTest {

	ProductCategoryEntityMapper productCategoryEntityMapper = new ProductCategoryEntityMapper();

	@Test
	void testToEntity() {
		ProductCategoryEntity result = productCategoryEntityMapper.toEntity(null);
		Assertions.assertNull(result);
	}

	@Test
	void testToDomain() {
		ProductCategory result = productCategoryEntityMapper.toDomain(new ProductCategoryEntity(0, "name"));
		Assertions.assertEquals(0, result.getId());
		Assertions.assertEquals("name", result.getName());
	}
}