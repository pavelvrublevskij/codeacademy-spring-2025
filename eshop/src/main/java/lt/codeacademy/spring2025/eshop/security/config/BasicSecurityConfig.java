package lt.codeacademy.spring2025.eshop.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BasicSecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
      .authorizeHttpRequests(authorizeRequests ->
        authorizeRequests.requestMatchers("/login/**").permitAll()
          .anyRequest()
          .authenticated())
      .formLogin(loginConfigurer ->
        loginConfigurer.permitAll()
          .loginPage("/login")
          .loginProcessingUrl("/login")
          .defaultSuccessUrl("/products", true)
          .usernameParameter("loginEmail")
          .passwordParameter("loginPassword")
      )
      .build();
  }
}
