package lt.codeacademy.spring2025.eshop.product.mapper;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import lt.codeacademy.spring2025.core.domain.Product;
import lt.codeacademy.spring2025.eshop.product.dto.ProductDto;
import org.junit.jupiter.api.Test;

class ProductDtoMapperTest {

  @Test
  void toProductDtoAllFieldsShouldBeMappedAsExpected() {
    // GIVEN
    ProductDtoMapper productDtoMapper = new ProductDtoMapper();
    Product product = Product.builder()
      .name("productName")
      .price(BigDecimal.ONE)
      .description("productDescription")
      .amount(100)
      .build();

    // WHEN
    ProductDto productDto = productDtoMapper.toDto(product);

    // THEN
    assertEquals("productName", productDto.getName());
    assertEquals(BigDecimal.ONE, productDto.getPrice());
    assertEquals("productDescription", productDto.getDescription());
    assertEquals(100, productDto.getAmount(), 0);
  }

  @Test
  void toProductDtoAllFieldsAreNullShouldReturnAllFieldsNullAsExpected() {
    // GIVEN
    ProductDtoMapper productDtoMapper = new ProductDtoMapper();
    Product product = Product.builder().build();

    // WHEN
    ProductDto productDto = productDtoMapper.toDto(product);

    // THEN
    assertNull( productDto.getName());
    assertNull(productDto.getPrice());
    assertNull(productDto.getDescription());
    assertEquals(0, productDto.getAmount(), 0);
  }
}