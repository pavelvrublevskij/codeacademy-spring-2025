package lt.codeacademy.spring2025.eshop.home.controller;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.HttpEndpoint;
import lt.codeacademy.spring2025.eshop.config.property.CompanyProp;
import lt.codeacademy.spring2025.eshop.config.property.DeveloperInfoProp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

  private final CompanyProp companyProp;
  private final DeveloperInfoProp developerInfoProp;

	@GetMapping(HttpEndpoint.HOME)
	public String openHomePage(Model model) {
    model.addAttribute("companyName", companyProp.getCompanyName());
    model.addAttribute("companyAddress", companyProp.getCompanyAddress());
    model.addAttribute("developerNames", developerInfoProp.getDeveloperNames());
    model.addAttribute("companyColor", companyProp.getCompanyColor());
		return "home";
	}

}
