package lt.codeacademy.spring2025.eshop.home.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import lt.codeacademy.spring2025.eshop.HttpEndpoint;
import lt.codeacademy.spring2025.eshop.core.util.EshopFormatConstant;

@Controller
public class HomeController {

	@GetMapping(HttpEndpoint.HOME)
	public String openHomePage(Model model) {
    final String formatterDateTime = DateTimeFormatter.ofPattern(EshopFormatConstant.DATE_TIME_FORMAT).format(LocalDateTime.now());
    model.addAttribute("dateTime", formatterDateTime);
		return "home";
	}

}
