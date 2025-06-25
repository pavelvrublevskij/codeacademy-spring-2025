package lt.codeacademy.spring2025.security.core.registration.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lt.codeacademy.spring2025.core.validation.annotation.fieldsstringcompare.FieldsStringCompare;
import lt.codeacademy.spring2025.core.validation.annotation.phonenumber.PhoneNumber;
import lt.codeacademy.spring2025.core.validation.annotation.phonenumber.PhoneNumberPrefixType;

@Builder
//@RepeatPassword
@FieldsStringCompare(
  firstField = "password",
  secondField = "passwordRepeat",
  message = "{user.signup.fields.not.match}")
public record UserSignUpDto(@NotBlank String name,
                            @NotBlank String surname,
                            @NotBlank String email,
                            @PhoneNumber(
                              prefixType = PhoneNumberPrefixType.LOCAL,
                              message = "Phone number length must be 9 characters"
                            ) String phoneNumber,
                            @NotBlank String zipCode,
                            @NotBlank String city,
                            @NotBlank String password,
                            @NotBlank String passwordRepeat) {}
