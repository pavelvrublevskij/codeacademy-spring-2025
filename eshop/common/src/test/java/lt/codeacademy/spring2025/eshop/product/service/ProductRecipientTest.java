package lt.codeacademy.spring2025.eshop.product.service;

import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;

import lt.codeacademy.spring2025.eshop.core.domain.Product;
import lt.codeacademy.spring2025.eshop.core.domain.ProductCategory;
import lt.codeacademy.spring2025.eshop.product.mapper.ProductEntityMapper;
import lt.codeacademy.spring2025.eshop.product.model.ProductCategoryEntity;
import lt.codeacademy.spring2025.eshop.product.model.ProductEntity;
import lt.codeacademy.spring2025.eshop.product.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProductRecipientTest {

  @Mock
  private ProductRepository productRepository;
  @Mock
  private ProductEntityMapper productEntityMapper;

  @InjectMocks
  private ProductRecipient productRecipient;

  @Test
  void getAllProductsShouldReturnList() {
    // given
    var product1 = ProductEntity.builder().name("Product 1").productCategories(Set.of(ProductCategoryEntity.builder().build())).build();
    var product2 = ProductEntity.builder().name("Product 2").productCategories(Set.of()).build();
    when(productRepository.findAll()).thenReturn(List.of(product1, product2));
    when(productEntityMapper.toDomain(product1)).thenReturn(Product.builder().name("Product 1").categories(Set.of(ProductCategory.builder().build())).build());
    when(productEntityMapper.toDomain(product2)).thenReturn(Product.builder().name("Product 2").categories(Set.of()).build());

    // when
    List<Product> allProducts = productRecipient.getAllProducts();

    // then
    Assertions.assertEquals(2, allProducts.size());
    Assertions.assertEquals("Product 1", allProducts.get(0).getName());
    Assertions.assertEquals(1, allProducts.get(0).getCategories().size());

    Assertions.assertEquals("Product 2", allProducts.get(1).getName());
    Assertions.assertEquals(0, allProducts.get(1).getCategories().size());
  }
}