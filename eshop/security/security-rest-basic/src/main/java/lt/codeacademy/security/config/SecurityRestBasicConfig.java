package lt.codeacademy.security.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Configuration
@EnableConfigurationProperties(ApplicationUsersPropertyConfig.class)
@RequiredArgsConstructor
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityRestBasicConfig {

  private final ApplicationUsersPropertyConfig applicationUsersPropertyConfig;

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
