package lt.codeacademy.spring2025.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import lt.codeacademy.spring2025.eshop.dto.Product;

@Controller
public class ProductController {

	@GetMapping("/products")
	public String openProducts(Model model) {
		model.addAttribute("product", new Product());
		return "product";
	}

	@PostMapping("/products/create")
	public String createProduct(Product product) {
		System.out.println(product);
		return "hello";
	}
}
