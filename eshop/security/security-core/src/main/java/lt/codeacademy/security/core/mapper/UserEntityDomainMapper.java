package lt.codeacademy.spring2025.security.core.mapper;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.security.core.domain.UserDomain;
import lt.codeacademy.spring2025.security.core.jpa.model.UserEntity;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserEntityDomainMapper {

  private final AuthorityEntityDomainMapper authorityEntityDomainMapper;

  public UserDomain toDomain(UserEntity entity) {
    return UserDomain.builder()
      .id(entity.getId())
      .name(entity.getFirstName())
      .surname(entity.getLastName())
      .email(entity.getEmail())
      .password(entity.getPassword())
      .authorities(authorityEntityDomainMapper.matToDomain(entity.getAuthorities()))
      .phoneNumber(entity.getPhoneNumber())
      .zipCode(entity.getZipCode())
      .build();
  }
}
