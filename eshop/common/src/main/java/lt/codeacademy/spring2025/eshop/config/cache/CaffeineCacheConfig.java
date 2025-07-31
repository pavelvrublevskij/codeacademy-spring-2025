package lt.codeacademy.spring2025.eshop.config.cache;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import static lt.codeacademy.spring2025.eshop.config.cache.CachingConstant.*;

@Configuration
@EnableCaching
@CacheConfig(cacheNames = {
  PRODUCTS_CACHE_NAME,
  PRODUCTS_PAGINATED_CACHE_NAME,
  PRODUCT_BY_UUID_CACHE_NAME
})
@Profile("cache-caffeine")
public class CaffeineCacheConfig extends CacheConfigProperty {

  @Bean
  public CacheManager cacheManager() {
    final SimpleCacheManager cacheManager = new SimpleCacheManager();

    cacheManager.setCaches(List.of(
      new CaffeineCache(PRODUCTS_CACHE_NAME, buildOf(productsMaxSize, productsTtlMinutes)),
      new CaffeineCache(PRODUCTS_PAGINATED_CACHE_NAME, buildOf(productsPaginatedMaxSize, productsPaginatedTtlMinutes)),
      new CaffeineCache(PRODUCT_BY_UUID_CACHE_NAME, buildOf(productByUUIDMaxSize, productByUUIDTtlMinutes))
    ));

    return cacheManager;
  }

  private Cache<Object, Object> buildOf(final long productsMaxSize, final long productsTtlMinutes) {
    return Caffeine.newBuilder()
      .maximumSize(productsMaxSize)
      .expireAfterWrite(productsTtlMinutes, TimeUnit.MINUTES)
      .recordStats()
      .build();
  }
}
