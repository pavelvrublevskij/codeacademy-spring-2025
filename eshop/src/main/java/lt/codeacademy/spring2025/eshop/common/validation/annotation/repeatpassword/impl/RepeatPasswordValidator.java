package lt.codeacademy.spring2025.eshop.common.validation.annotation.repeatpassword.impl;

import java.util.Objects;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lt.codeacademy.spring2025.eshop.common.validation.annotation.repeatpassword.RepeatPassword;
import lt.codeacademy.spring2025.eshop.user.dto.UserSignUpDto;

public class RepeatPasswordValidator implements ConstraintValidator<RepeatPassword, UserSignUpDto> {

  @Override
  public boolean isValid(UserSignUpDto userSignUpDto, ConstraintValidatorContext context) {
    return Objects.nonNull(userSignUpDto.password()) && Objects.nonNull(userSignUpDto.passwordRepeat())
      && userSignUpDto.password().equals(userSignUpDto.passwordRepeat());
  }
}
