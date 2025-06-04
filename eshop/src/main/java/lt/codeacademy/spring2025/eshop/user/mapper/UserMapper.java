package lt.codeacademy.spring2025.eshop.user.mapper;

import java.util.function.Function;
import java.util.stream.Collectors;

import lt.codeacademy.spring2025.eshop.user.dto.UserDto;
import lt.codeacademy.spring2025.eshop.user.dto.UserRoleDto;
import lt.codeacademy.spring2025.eshop.user.model.AuthorityEntity;
import lt.codeacademy.spring2025.eshop.user.model.UserEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

  private final Function<AuthorityEntity, String> getAuthorityName = authority -> "ROLE_" + authority.getName();

  public UserDetails toDto(UserEntity userEntity) {
    return UserRoleDto.builder()
        .user(UserDto.builder()
            .email(userEntity.getEmail())
            .password(userEntity.getPassword())
            .firstName(userEntity.getFirstName())
            .lastName(userEntity.getLastName())
            .build())
        .roles(userEntity.getAuthorities().stream()
            .map(getAuthorityName)
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toSet()))
        .build();
  }
}
