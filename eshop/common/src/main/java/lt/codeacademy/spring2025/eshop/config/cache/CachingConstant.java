package lt.codeacademy.spring2025.eshop.config.cache;

/**
 * Interface to keep all application cache names in one place.
 */
public interface CachingConstant {

  String PRODUCTS_CACHE_NAME = "products";
  String PRODUCTS_PAGINATED_CACHE_NAME = "productsPaginated";
  String PRODUCT_BY_UUID_CACHE_NAME = "productByUUIDPaginated";
}
