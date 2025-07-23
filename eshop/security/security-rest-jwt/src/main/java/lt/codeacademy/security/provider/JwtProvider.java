package lt.codeacademy.security.provider;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import lt.codeacademy.security.core.dto.UserRoleDto;

@Component
public class JwtProvider {

  public String createToken(final Authentication authentication) {
    final UserRoleDto userRoleDto = (UserRoleDto) authentication.getPrincipal();
    return "cia mano tokenas";
  }
}
