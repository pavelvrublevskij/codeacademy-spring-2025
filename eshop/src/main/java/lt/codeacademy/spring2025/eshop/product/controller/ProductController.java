package lt.codeacademy.spring2025.eshop.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.product.dto.ProductDto;
import lt.codeacademy.spring2025.eshop.product.service.ProductService;

@Controller
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;

	@GetMapping("/products")
	public String openProducts(Model model) {
		model.addAttribute("product", new ProductDto());
		return "product";
	}

	@PostMapping("/products/create")
	public String createProduct(ProductDto product) {
		productService.save(product);
		productService.getAllProducts().forEach(System.out::println);
		return "home";
	}
}
