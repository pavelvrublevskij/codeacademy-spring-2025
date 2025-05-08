package lt.codeacademy.spring2025.eshop.product.config;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lt.codeacademy.spring2025.eshop.core.domain.Product;
import lt.codeacademy.spring2025.eshop.product.service.ProductService;

@Configuration
@RequiredArgsConstructor
@Log4j2
public class ProductMockDataConfig {

  private static final int MAX_COUNT = 10;

  private final ProductService productService;

  @Bean
  public Void intiProducts() {
    log.atDebug().log("=== Start initializing product mock data ===");
    var count = 0;
    final Faker faker = new Faker();
    while (MAX_COUNT >= count) {
      productService.save(Product.builder()
          .id(UUID.randomUUID())
          .name("(faker)" + faker.food().fruit())
          .amount(faker.number().numberBetween(50, 1000))
          .price(BigDecimal.valueOf(faker.number().numberBetween(2, 99)))
          .description(faker.chuckNorris().fact())
        .build());
      count++;
    }

    log.atDebug().log("=== Finished Initializing product mock data ===");
    return null;
  }
}
