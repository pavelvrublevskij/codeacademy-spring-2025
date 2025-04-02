package lt.codeacademy.spring2025.eshop.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String openHomePage() {
		return "home";
	}

}
