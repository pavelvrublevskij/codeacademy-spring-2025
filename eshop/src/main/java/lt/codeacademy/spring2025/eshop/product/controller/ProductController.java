package lt.codeacademy.spring2025.eshop.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.HttpEndpoint;
import lt.codeacademy.spring2025.eshop.product.dto.ProductDto;
import lt.codeacademy.spring2025.eshop.product.mapper.ProductDtoMapper;
import lt.codeacademy.spring2025.eshop.product.service.ProductService;

@Controller
@RequiredArgsConstructor
public class ProductController {

  public static final String PRODUCT_CREATE_VIEW = "product/product";
  public static final String PRODUCT_PRODUCTS = "product/products";
  private final ProductService productService;
	private final ProductDtoMapper productDtoMapper;

	@GetMapping(HttpEndpoint.PRODUCTS)
	public String getProducts(Model model) {
		model.addAttribute("productList", productService.getAllProducts().stream().map(productDtoMapper::toProductDto).toList());
		return PRODUCT_PRODUCTS;
	}

	@GetMapping(HttpEndpoint.PRODUCTS_CREATE)
	public String openProductForCreate(Model model) {
		model.addAttribute("product", ProductDto.builder().build());
		return PRODUCT_CREATE_VIEW;
	}

	@PostMapping(HttpEndpoint.PRODUCTS_CREATE)
	public String createProduct(ProductDto product) {
		productService.save(productDtoMapper.toProduct(product));
		return "home";
	}

  @GetMapping(HttpEndpoint.PRODUCT_UPDATE)
  public String updateProduct(Model model,
                              @PathVariable long productId) {
    model.addAttribute("product", productService.getProductById(productId));
    return PRODUCT_CREATE_VIEW;
  }

  @PostMapping(HttpEndpoint.PRODUCT_UPDATE)
  public String updateProduct(Model model,
                              ProductDto product,
                              @PathVariable long productId) {
    productService.update(productDtoMapper.toProduct(product));

    return getProducts(model);
  }
}
