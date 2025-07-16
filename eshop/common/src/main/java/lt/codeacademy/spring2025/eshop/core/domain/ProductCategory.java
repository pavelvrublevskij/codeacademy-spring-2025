package lt.codeacademy.spring2025.eshop.core.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProductCategory {

  private int id;
  private String name;
}
