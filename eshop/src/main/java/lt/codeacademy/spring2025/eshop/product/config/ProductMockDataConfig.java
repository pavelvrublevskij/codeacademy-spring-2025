package lt.codeacademy.spring2025.eshop.product.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.core.domain.Product;
import lt.codeacademy.spring2025.eshop.product.service.ProductService;

@Configuration
@RequiredArgsConstructor
public class ProductMockDataConfig {

  private static final int MAX_COUNT = 10;

  private final ProductService productService;

  @Bean
  public Void intiProducts() {
    var count = 0;
    while (MAX_COUNT >= count) {
      productService.save(Product.builder()
          .name("Nokia" + count)
          .amount(100+count)
          .price(20*(count+1))
        .build());
      count++;
    }

    return null;
  }
}
