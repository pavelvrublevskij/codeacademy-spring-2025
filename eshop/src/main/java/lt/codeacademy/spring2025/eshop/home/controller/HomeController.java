package lt.codeacademy.spring2025.eshop.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import lt.codeacademy.spring2025.eshop.HttpEndpoint;

@Controller
public class HomeController {

	@GetMapping(HttpEndpoint.HOME)
	public String openHomePage() {
		return "home";
	}

}
