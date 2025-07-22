package lt.codeacademy.security.config;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lt.codeacademy.security.dto.GlobalUserDto;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@ConfigurationProperties("global")
public class ApplicationUsersPropertyConfig {

  private final List<GlobalUserDto> users = new ArrayList<>();
}
