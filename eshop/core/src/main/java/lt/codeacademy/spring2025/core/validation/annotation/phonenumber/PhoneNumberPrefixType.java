package lt.codeacademy.spring2025.core.validation.annotation.phonenumber;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum PhoneNumberPrefixType {

  GLOBAL("+370"),
  LOCAL("0");

  private final String prefix;
}
