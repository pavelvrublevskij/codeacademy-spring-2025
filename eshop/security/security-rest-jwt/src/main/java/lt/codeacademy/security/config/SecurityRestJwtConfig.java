package lt.codeacademy.security.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lt.codeacademy.security.filter.JwtAuthenticationFilter;

@Log4j2
@Configuration
@EnableConfigurationProperties(ApplicationUsersPropertyConfig.class)
@RequiredArgsConstructor
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityRestJwtConfig {

  private final ApplicationUsersPropertyConfig applicationUsersPropertyConfig;
  private final ObjectMapper objectMapper;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http,
                                                 AuthenticationManager authenticationManager) throws Exception {
    return http
      // Disable CSRF protection for REST APIs.
      .csrf(AbstractHttpConfigurer::disable)

      // turn on http basic authentication in inMemoryUserDetailsService.
      .httpBasic(httpConfigurer -> httpConfigurer.init(http))

      // ses session management to stateless, as REST APIs should not maintain session state.
      .sessionManagement(sessionManagementConfigurer ->
        sessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

      // set authorization access to whole request.
      .authorizeHttpRequests(authorizeRequest ->
        authorizeRequest
          .requestMatchers(
            "/swagger-ui/**"
            , "/v3/api-docs/**"
          ).permitAll()
          .anyRequest().authenticated())
      .addFilter(new JwtAuthenticationFilter(authenticationManager, objectMapper))
      .build();
  }

  @Bean AuthenticationManager authenticationManager(final UserDetailsService userDetailsService,
                                                    final PasswordEncoder passwordEncoder) {
    final DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    daoAuthenticationProvider.setUserDetailsService(userDetailsService);
    daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);

    return new ProviderManager(daoAuthenticationProvider);
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }

  @Bean
  public UserDetailsService inMemoryUserDetailsService() {
    return new InMemoryUserDetailsManager(applicationUsersPropertyConfig.getUsers().stream()
      .map(user -> {
        log.info("Creating global user: {}", user);

        return User.withUsername(user.username())
          .password(user.password())
          .roles(user.roles())
          .build();
      })
      .toList());
  }

}
