package lt.codeacademy.spring2025.eshop.home.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import lt.codeacademy.spring2025.eshop.HttpEndpoint;
import lt.codeacademy.spring2025.eshop.core.util.EshopDateTimeFormatUtil;

@Controller
public class HomeController {

	@GetMapping(HttpEndpoint.HOME)
	public String openHomePage(Model model) {
    model.addAttribute("dateTime",
      EshopDateTimeFormatUtil.getFormatterDateTime(LocalDateTime.now()));
		return "home";
	}

}
