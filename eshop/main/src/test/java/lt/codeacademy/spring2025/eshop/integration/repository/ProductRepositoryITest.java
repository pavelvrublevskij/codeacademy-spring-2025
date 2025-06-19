package lt.codeacademy.spring2025.eshop.integration.repository;

import java.math.BigDecimal;
import java.util.UUID;

import lt.codeacademy.spring2025.eshop.product.model.ProductEntity;
import lt.codeacademy.spring2025.eshop.product.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ProductRepositoryITest {

  @Autowired
  private ProductRepository productRepository;

  @Test
  public void testGetAllProductsAreEmpty() {
    // This test will check if the repository can fetch all products.
    // You can add more assertions or logic here to validate the results.
    var products = productRepository.findAll();
    assert products.isEmpty() : "Product list should be empty";
  }

  @Test
  public void testCreateANewProduct() {
    // This test will check if a new product can be created.
    final UUID productId = UUID.randomUUID();

    final ProductEntity product = ProductEntity.builder()
      .name("Test Product")
      .productId(productId)
      .price(new BigDecimal("19.99"))
      .amountInStock(100)
      .description("This is a test product")
      .build();

    // when
    productRepository.save(product);

    // then
    var savedProduct = productRepository.findByProductId(productId);
    assert savedProduct.isPresent() : "Product should be saved and retrievable";
    assert savedProduct.get().getName().equals("Test Product") : "Product name should match";
    assert savedProduct.get().getPrice().compareTo(new BigDecimal("19.99")) == 0 : "Product price should match";
    assert savedProduct.get().getAmountInStock() == 100 : "Product stock amount should match";
    assert savedProduct.get().getDescription().equals("This is a test product") : "Product description should match";
    assert savedProduct.get().getProductId().equals(productId) : "Product ID should match";
  }
}
