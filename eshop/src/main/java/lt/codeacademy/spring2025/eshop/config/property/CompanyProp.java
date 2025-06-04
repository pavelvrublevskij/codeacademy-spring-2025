package lt.codeacademy.spring2025.eshop.config.property;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class CompanyProp {

  @Value("${company.name}")
  private String companyName;
  @Value("${company.address}")
  private String companyAddress;
  @Value("${company.color:#000000}")
  private String companyColor;
}
