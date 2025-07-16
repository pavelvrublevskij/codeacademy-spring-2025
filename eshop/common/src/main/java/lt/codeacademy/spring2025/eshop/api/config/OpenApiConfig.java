package lt.codeacademy.spring2025.eshop.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .info(new Info()
            .title("E-Shop API")
            .version("1.0.0")
            .description("API documentation for the E-Shop application")
            .contact(new Contact()
              .email("developer@eshop.lt")
              .url("/contact")
              .name("E-Shop Support Team")
            )
          .license(new License()
            .name("Apache 2.0")
            .url("http://www.apache.org/licenses/LICENSE-2.0")
          )
        );
  }
}
