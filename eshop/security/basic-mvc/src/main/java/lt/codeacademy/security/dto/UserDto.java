package lt.codeacademy.security.dto;

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
