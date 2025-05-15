package lt.codeacademy.spring2025.eshop.common.validation.annotation.phonenumber.impl;

import java.util.Optional;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lt.codeacademy.spring2025.eshop.common.validation.annotation.phonenumber.PhoneNumber;
import lt.codeacademy.spring2025.eshop.common.validation.annotation.phonenumber.PhoneNumberPrefixType;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

  private PhoneNumberPrefixType prefixType;

  @Override
  public void initialize(PhoneNumber constraintAnnotation) {
    this.prefixType = constraintAnnotation.prefixType();
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    final int numberLength = Optional.ofNullable(value).orElse("").length();
    if (prefixType == PhoneNumberPrefixType.GLOBAL) {
      return numberLength == 12;
    } else {
      return numberLength == 9;
    }

  }
}
