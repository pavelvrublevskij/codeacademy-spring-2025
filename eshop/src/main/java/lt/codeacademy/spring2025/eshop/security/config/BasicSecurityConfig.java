package lt.codeacademy.spring2025.eshop.security.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
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
    final UserDetails adminUser = User.builder()
      .username("admin@eshop.lt")
      // Steps how to encode password:
      // 1. Open PasswordEncoderFactories and look for bcrypt, we will see that bcypt use BCryptPasswordEncoder class
      // 2. Go to BCryptPasswordEncoder implementation and add break point on 129 line
      // 3. Run application in debug mode and when stopped press Alt + F8 (Evaluation window should appear)
      // 4. Write there this.encode("your password") and press EVALUATE button
      // or skip all steps and use https://bcrypt-generator.com/ :)))
      .password("{bcrypt}$2a$12$599FRBXq/Oxq1SgxuThflOT.kIyO2.XFhGMee6bud2gIYyGE6WRoG") // {noop} indicates no password encoder is used
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
