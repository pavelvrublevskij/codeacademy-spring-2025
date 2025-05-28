package lt.codeacademy.spring2025.eshop.security.config;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lt.codeacademy.spring2025.eshop.security.domain.GlobalUserDto;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@ConfigurationProperties("global")
public class ApplicationUsersPropertyConfig {

  private final List<GlobalUserDto> users = new ArrayList<>();
}
