package lt.codeacademy.spring2025.eshop.common.validation.impl;

import java.util.Optional;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lt.codeacademy.spring2025.eshop.common.validation.PhoneNumber;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return Optional.ofNullable(value).orElse("").length() == 12;
  }
}
