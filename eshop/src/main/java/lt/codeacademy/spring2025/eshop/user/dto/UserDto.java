package lt.codeacademy.spring2025.eshop.user.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserDto {

  private String firstName;
  private String lastName;
  private String email;
  private String password;
}
