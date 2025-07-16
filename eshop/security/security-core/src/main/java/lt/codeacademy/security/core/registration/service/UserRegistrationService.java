package lt.codeacademy.security.core.registration.service;

import java.util.Optional;
import java.util.Set;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.security.core.registration.dto.UserSignUpDto;
import lt.codeacademy.security.core.jpa.model.AuthorityEntity;
import lt.codeacademy.security.core.jpa.model.UserEntity;
import lt.codeacademy.security.core.jpa.repository.AuthorityRepository;
import lt.codeacademy.security.core.jpa.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserRegistrationService {

  private final UserRepository userRepository;
  private final AuthorityRepository authorityRepository;

  @Transactional
  public void createUser(final UserSignUpDto userSignUpDto) {
    Optional<AuthorityEntity> user = authorityRepository.findByName("USER");

    user.ifPresent(authority ->
      doRegister(userSignUpDto, authority));
  }

  private void doRegister(final UserSignUpDto userSignUpDto, final AuthorityEntity authority) {
    userRepository.save(
      UserEntity.builder()
        .email(userSignUpDto.email())
        .firstName(userSignUpDto.name())
        .lastName(userSignUpDto.surname())
        .phoneNumber(userSignUpDto.phoneNumber())
        .city(userSignUpDto.city())
        .password(new BCryptPasswordEncoder().encode(userSignUpDto.password()))
        .zipCode(userSignUpDto.zipCode())
        .authorities(Set.of(authority))
        .build()
    );
  }

}
