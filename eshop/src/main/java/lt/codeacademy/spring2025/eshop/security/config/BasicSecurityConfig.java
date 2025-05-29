package lt.codeacademy.spring2025.eshop.security.config;

import javax.sql.DataSource;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Log4j2
@Configuration
@RequiredArgsConstructor
public class BasicSecurityConfig {

  private final DataSource datasource;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
      .authorizeHttpRequests(authorizeRequests ->
        authorizeRequests.requestMatchers(
          "/",
          "/login/**",
          "/eshop_h2/**",
          "/products",
          "/products/find/**",
          "/cart/**",
          "/users/sign-up/**"
          ).permitAll()
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

  @Bean
  public WebSecurityCustomizer webSecurityCustomizer() {
    return web -> web.ignoring()
      .requestMatchers(
        PathRequest.toH2Console(),
        PathRequest.toStaticResources().atCommonLocations()  // add this line if static files prevented by security
      );
  }

  @Bean
  public UserDetailsService jdbcUserDetailsService() {
    var users = new JdbcUserDetailsManager(datasource);
    users.setUsersByUsernameQuery("SELECT email AS username, password, TRUE AS enabled FROM users WHERE email = ?");
    users.setAuthoritiesByUsernameQuery("SELECT email AS username, 'ROLE_ADMIN' AS authority FROM users WHERE email = ?");

    return users;
  }
}
