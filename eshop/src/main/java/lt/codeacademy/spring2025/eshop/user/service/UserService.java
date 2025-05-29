package lt.codeacademy.spring2025.eshop.user.service;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.user.dto.UserSignUpDto;
import lt.codeacademy.spring2025.eshop.user.model.UserEntity;
import lt.codeacademy.spring2025.eshop.user.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository.findByEmail(username)
      .orElseThrow(() -> new UsernameNotFoundException("User with email " + username + " not found"));
  }

  public void createUser(final UserSignUpDto userSignUpDto) {
    userRepository.save(
      UserEntity.builder()
        .email(userSignUpDto.email())
        .firstName(userSignUpDto.name())
        .lastName(userSignUpDto.surname())
        .phoneNumber(userSignUpDto.phoneNumber())
        .city(userSignUpDto.city())
        .password(new BCryptPasswordEncoder().encode(userSignUpDto.password()))
        .zipCode(userSignUpDto.zipCode())
        .build()
    );
  }
}
