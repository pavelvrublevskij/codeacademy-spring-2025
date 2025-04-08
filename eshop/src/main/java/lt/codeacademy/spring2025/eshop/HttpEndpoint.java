package lt.codeacademy.spring2025.eshop;

public final class HttpEndpoint {

  public static final String HOME = "/";
  public static final String PRODUCTS = "/products";
  public static final String PRODUCTS_CREATE = PRODUCTS + "/create";
	public static final String PRODUCT_UPDATE = PRODUCTS + "/{productId}/update";
  public static final String PRODUCTS_DELETE = PRODUCTS + "/{productId}/delete";
}
