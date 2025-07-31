package lt.codeacademy.spring2025.eshop.config.cache;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.github.benmanes.caffeine.cache.Caffeine;

import static lt.codeacademy.spring2025.eshop.config.cache.CachingConstant.PRODUCTS_CACHE_NAME;

@Configuration
@EnableCaching
@CacheConfig(cacheNames = {
  PRODUCTS_CACHE_NAME
})
@Profile("cache-caffeine")
public class CaffeineCacheConfig {

  @Value("${cache.products.max-size:1000}")
  private long productsMaxSize;
  @Value("${cache.products.ttl:1}")
  private long productsTtlMinutes;

  @Bean
  public CacheManager cacheManager() {
    final SimpleCacheManager cacheManager = new SimpleCacheManager();

    cacheManager.setCaches(List.of(
      new CaffeineCache(PRODUCTS_CACHE_NAME,
        Caffeine.newBuilder()
          .maximumSize(productsMaxSize)
          .expireAfterWrite(productsTtlMinutes, TimeUnit.MINUTES)
          .recordStats()
          .build()
      )
    ));

    return cacheManager;
  }
}
