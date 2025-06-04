package lt.codeacademy.spring2025.eshop.config.property;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class DeveloperInfoProp {

  @Value("${developer.name}")
  private String developerName;
}
