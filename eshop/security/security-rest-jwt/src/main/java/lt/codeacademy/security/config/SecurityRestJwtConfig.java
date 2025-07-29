package lt.codeacademy.security.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lt.codeacademy.security.filter.JwtAuthorizationFilter;
import lt.codeacademy.security.provider.JwtProvider;

@Log4j2
@Configuration
@EnableConfigurationProperties(ApplicationUsersPropertyConfig.class)
@RequiredArgsConstructor
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityRestJwtConfig {

  private final UserDetailsService userDetailsService;
  private final JwtProvider jwtProvider;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
      // Disable CSRF protection for REST APIs.
      .csrf(AbstractHttpConfigurer::disable)

      // turn on http basic authentication using Database.
      .httpBasic(httpConfigurer -> httpConfigurer.init(http))

      // ses session management to stateless, as REST APIs should not maintain session state.
      .sessionManagement(sessionManagementConfigurer ->
        sessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

      // set authorization access to whole request.
      .authorizeHttpRequests(authorizeRequest ->
        authorizeRequest
          .requestMatchers(
            "/api/login"
            , "/swagger-ui/**"
            , "/v3/api-docs/**"
            , "/api/products/**"
            , "/api/integrations/**"
          ).permitAll()
          .anyRequest().authenticated())
      .addFilterBefore(new JwtAuthorizationFilter(jwtProvider), UsernamePasswordAuthenticationFilter.class)
      .build();
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationProvider authenticationProvider) {
    return new ProviderManager(authenticationProvider);
  }

  @Bean
  public AuthenticationProvider authenticationProvider() {
    final var authenticationProvider = new DaoAuthenticationProvider();
    authenticationProvider.setUserDetailsService(userDetailsService);
    authenticationProvider.setPasswordEncoder(passwordEncoder());
    return authenticationProvider;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
