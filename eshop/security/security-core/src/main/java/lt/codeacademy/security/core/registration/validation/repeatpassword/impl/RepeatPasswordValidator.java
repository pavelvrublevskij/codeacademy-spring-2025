package lt.codeacademy.security.core.registration.validation.repeatpassword.impl;

import java.util.Objects;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lt.codeacademy.security.core.registration.dto.UserSignUpDto;
import lt.codeacademy.security.core.registration.validation.repeatpassword.RepeatPassword;


public class RepeatPasswordValidator implements ConstraintValidator<RepeatPassword, UserSignUpDto> {

  @Override
  public boolean isValid(UserSignUpDto userSignUpDto, ConstraintValidatorContext context) {
    return Objects.nonNull(userSignUpDto.password()) && Objects.nonNull(userSignUpDto.passwordRepeat())
      && userSignUpDto.password().equals(userSignUpDto.passwordRepeat());
  }
}
