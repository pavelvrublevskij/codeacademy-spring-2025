package lt.codeacademy.spring2025.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@GetMapping("/hello")
	public String sayHello(@RequestParam String name, @RequestParam int age) {
		System.out.println(name);
		System.out.println(age);
		return "hello.html";
	}

}
