package lt.codeacademy.security.core.user.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.security.core.jpa.repository.UserRepository;
import lt.codeacademy.security.core.mapper.UserEntityDomainMapper;
import lt.codeacademy.security.core.mapper.UserRoleDtoMapper;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

  private final UserRepository userRepository;
  private final UserEntityDomainMapper userEntityDomainMapper;
  private final UserRoleDtoMapper userRoleDtoMapper;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRoleDtoMapper.toDto(
      userRepository.findUserByEmailWithAuthorities(username)
        .map(userEntityDomainMapper::toDomain)
        .orElseThrow(() -> new UsernameNotFoundException("User with email " + username + " not found")));
  }
}
