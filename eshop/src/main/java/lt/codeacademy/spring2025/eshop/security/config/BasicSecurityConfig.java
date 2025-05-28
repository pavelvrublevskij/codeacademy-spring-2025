package lt.codeacademy.spring2025.eshop.security.config;

import javax.sql.DataSource;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Log4j2
@Configuration
@EnableConfigurationProperties(ApplicationUsersPropertyConfig.class)
@RequiredArgsConstructor
public class BasicSecurityConfig {

  private final ApplicationUsersPropertyConfig applicationUsersPropertyConfig;
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
    var jdbcUserDetailsManager = new JdbcUserDetailsManager(datasource);

    applicationUsersPropertyConfig.getUsers()
      .forEach(user -> {
        log.info("Creating global user: {}", user);

        jdbcUserDetailsManager.createUser(
          User.withUsername(user.username())
            .password(user.password())
            .roles(user.roles())
            .build());
      });

    return jdbcUserDetailsManager;
  }
}
