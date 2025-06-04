package lt.codeacademy.spring2025.eshop.user.service;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.user.mapper.UserMapper;
import lt.codeacademy.spring2025.eshop.user.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository.findUserByEmailWithAuthorities(username)
      .map(userMapper::toDto)
      .orElseThrow(() -> new UsernameNotFoundException("User with email " + username + " not found"));
  }
}
