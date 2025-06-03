package lt.codeacademy.spring2025.eshop.home.controller;

import lt.codeacademy.spring2025.eshop.HttpEndpoint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @Value("${company.name}")
  private String companyName;
  @Value("${company.address}")
  private String companyAddress;
  @Value("${company.color:#000000}")
  private String companyColor;
  @Value("${developer.name}")
  private String developerName;

	@GetMapping(HttpEndpoint.HOME)
	public String openHomePage(Model model) {
    model.addAttribute("companyName", companyName);
    model.addAttribute("companyAddress", companyAddress);
    model.addAttribute("developerName", developerName);
    model.addAttribute("companyColor", companyColor);
		return "home";
	}

}
