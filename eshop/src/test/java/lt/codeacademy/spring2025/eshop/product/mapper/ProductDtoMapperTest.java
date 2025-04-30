package lt.codeacademy.spring2025.eshop.product.mapper;

import org.junit.jupiter.api.Test;

import lt.codeacademy.spring2025.eshop.core.domain.Product;
import lt.codeacademy.spring2025.eshop.product.dto.ProductDto;

import static org.junit.jupiter.api.Assertions.*;

class ProductDtoMapperTest {

  @Test
  void toProductDtoAllFieldsShouldBeMappedAsExpected() {
    // GIVEN
    ProductDtoMapper mapper = new ProductDtoMapper();
    Product product = Product.builder()
      .name("productName")
      .price(1.0)
      .description("productDescription")
      .amount(100)
      .build();

    // WHEN
    ProductDto productDto = mapper.toProductDto(product);

    // THEN
    assertEquals("productName", productDto.getName());
    assertEquals(1.0, productDto.getPrice(), 0);
    assertEquals("productDescription", productDto.getDescription());
    assertEquals(100, productDto.getAmount(), 0);
  }

  @Test
  void toProductDtoAllFieldsAreNullShouldReturnAllFieldsNullAsExpected() {
    // GIVEN
    ProductDtoMapper mapper = new ProductDtoMapper();
    Product product = Product.builder().build();

    // WHEN
    ProductDto productDto = mapper.toProductDto(product);

    // THEN
    assertNull( productDto.getName());
    assertEquals(0, productDto.getPrice(), 0);
    assertNull(productDto.getDescription());
    assertEquals(0, productDto.getAmount(), 0);
  }
}