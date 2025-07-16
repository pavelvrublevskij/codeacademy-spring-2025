package lt.codeacademy.spring2025.eshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
    "lt.codeacademy.spring2025",
    "lt.codeacademy.security"
})
@EnableJpaRepositories(basePackages = {
    "lt.codeacademy.spring2025",
    "lt.codeacademy.security"
})
@EntityScan(basePackages = {
    "lt.codeacademy.spring2025",
    "lt.codeacademy.security"
})
public class EshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(EshopApplication.class, args);
	}

}