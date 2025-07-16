package lt.codeacademy.spring2025.eshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
    "lt.codeacademy.spring2025.eshop",
    "lt.codeacademy.spring2025.core",
    "lt.codeacademy.security"
})
public class EshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(EshopApplication.class, args);
	}

}
