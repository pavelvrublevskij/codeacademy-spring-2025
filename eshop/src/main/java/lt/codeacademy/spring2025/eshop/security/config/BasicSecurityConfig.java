package lt.codeacademy.spring2025.eshop.security.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BasicSecurityConfig {

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
        PathRequest.toH2Console()
//        PathRequest.toStaticResources().atCommonLocations()  // add this line if static files prevented by security
      );
  }

  @Bean
  public UserDetailsService inMemoryUserDetailsService() {
    final PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    final UserDetails adminUser = User.builder()
      .username("admin@eshop.lt")
      .password(encoder.encode("admin"))
      .roles("ADMIN", "USER")
      .build();
    final UserDetails regularUser = User.builder()
      .username("user@eshop.lt")
      .password("{noop}user") // {noop} indicates no password encoder is used
      .roles("USER")
      .build();

    return new InMemoryUserDetailsManager(adminUser, regularUser);
  }
}
