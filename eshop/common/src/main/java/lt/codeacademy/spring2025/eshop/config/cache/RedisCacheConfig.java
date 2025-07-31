package lt.codeacademy.spring2025.eshop.config.cache;

import java.time.Duration;

import static lt.codeacademy.spring2025.eshop.config.cache.CachingConstant.*;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableCaching
@CacheConfig(cacheNames = {
  PRODUCTS_CACHE_NAME,
  PRODUCTS_PAGINATED_CACHE_NAME,
  PRODUCT_BY_UUID_CACHE_NAME
})
@Profile("cache-redis")
public class RedisCacheConfig extends CacheConfigProperty {

  @Bean
  public CacheManager cacheManager(final RedisConnectionFactory redisConnectionFactory) {
    final RedisCacheConfiguration defaultConfig = RedisCacheConfiguration.defaultCacheConfig()
      .entryTtl(Duration.ofMinutes(productsTtlMinutes))
      .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
      .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()))
      .disableCachingNullValues();

    return RedisCacheManager.builder(redisConnectionFactory)
      .cacheDefaults(defaultConfig)
      .withCacheConfiguration(PRODUCTS_CACHE_NAME, cacheConfigurationFor(productsTtlMinutes))
      .withCacheConfiguration(PRODUCT_BY_UUID_CACHE_NAME, cacheConfigurationFor(productByUUIDTtlMinutes))
      .withCacheConfiguration(PRODUCTS_PAGINATED_CACHE_NAME, cacheConfigurationFor(productsPaginatedTtlMinutes))
      .build();
  }

  private RedisCacheConfiguration cacheConfigurationFor(final long ttlMinutes) {
    return RedisCacheConfiguration.defaultCacheConfig()
      .entryTtl(Duration.ofMinutes(ttlMinutes))
      .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
      .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()))
      .disableCachingNullValues();
  }
}
