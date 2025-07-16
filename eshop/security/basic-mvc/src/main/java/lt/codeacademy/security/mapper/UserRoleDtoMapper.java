package lt.codeacademy.security.mapper;

import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import lt.codeacademy.security.core.domain.AuthorityDomain;
import lt.codeacademy.security.core.domain.UserDomain;
import lt.codeacademy.security.dto.UserDto;
import lt.codeacademy.security.dto.UserRoleDto;

@Component
public class UserRoleDtoMapper {

  private final Function<AuthorityDomain, String> getAuthorityName = authority -> "ROLE_" + authority.getName();

  public UserDetails toDto(UserDomain userEntity) {
    return UserRoleDto.builder()
      .user(UserDto.builder()
        .email(userEntity.getEmail())
        .password(userEntity.getPassword())
        .firstName(userEntity.getName())
        .lastName(userEntity.getSurname())
        .build())
      .roles(userEntity.getAuthorities().stream()
        .map(getAuthorityName)
        .map(SimpleGrantedAuthority::new)
        .collect(Collectors.toSet()))
      .build();
  }
}
