package lt.codeacademy.spring2025.eshop.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;

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
        )
      .components(getComponents());
  }

  private Components getComponents() {
    var securityBasicScheme = getSecurityBasicScheme();
    var securityJwtScheme = getSecurityJwtScheme();

    return new Components()
      .addSecuritySchemes(securityBasicScheme.getName(), securityBasicScheme)
      .addSecuritySchemes(securityJwtScheme.getName(), securityJwtScheme);
  }

  private SecurityScheme getSecurityBasicScheme() {
    return new SecurityScheme()
      .name(HttpHeaders.AUTHORIZATION)
      .type(SecurityScheme.Type.HTTP)
      .scheme("basic")
      .description("Basic authentication for API access");
  }

  private SecurityScheme getSecurityJwtScheme() {
    return new SecurityScheme()
      .name(HttpHeaders.AUTHORIZATION)
      .description("JWT Bearer Token for API access. To get required token, use the /login endpoint.")
      .type(SecurityScheme.Type.HTTP)
      .scheme("bearer")
      .bearerFormat("JWT");
  }
}
