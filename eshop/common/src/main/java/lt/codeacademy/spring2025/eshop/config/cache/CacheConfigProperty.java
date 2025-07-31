package lt.codeacademy.spring2025.eshop.config.cache;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfigProperty {

  @Value("${cache.products.max-size:1000}")
  protected long productsMaxSize;
  @Value("${cache.products.ttl:1}")
  protected long productsTtlMinutes;

  @Value("${cache.products.paginated.max-size:100}")
  protected long productsPaginatedMaxSize;
  @Value("${cache.products.paginated.ttl:5}")
  protected long productsPaginatedTtlMinutes;

  @Value("${cache.product.byUUID.max-size:1}")
  protected long productByUUIDMaxSize;
  @Value("${cache.product.byUUID.ttl:10}")
  protected long productByUUIDTtlMinutes;
}
