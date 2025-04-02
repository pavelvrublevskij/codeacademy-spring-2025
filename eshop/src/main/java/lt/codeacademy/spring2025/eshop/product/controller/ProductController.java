package lt.codeacademy.spring2025.eshop.product.controller;

import java.util.Collections;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.product.dto.ProductDto;
import lt.codeacademy.spring2025.eshop.product.mapper.ProductDtoMapper;
import lt.codeacademy.spring2025.eshop.product.service.ProductService;

@Controller
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;
	private final ProductDtoMapper productDtoMapper;

	@GetMapping("/products")
	public String getProducts(Model model) {
		model.addAttribute("productList", productService.getAllProducts().stream().map(productDtoMapper::toProductDto).toList());
		return "product/products";
	}

	@GetMapping("/products/create")
	public String openProductForCreate(Model model) {
		model.addAttribute("product", ProductDto.builder().build());
		return "product/product";
	}

	@PostMapping("/products/create")
	public String createProduct(ProductDto product) {
		productService.save(productDtoMapper.toProduct(product));
		return "home";
	}
}
