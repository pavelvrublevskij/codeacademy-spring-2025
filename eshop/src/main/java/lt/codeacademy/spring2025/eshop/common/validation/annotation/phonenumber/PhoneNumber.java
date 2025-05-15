package lt.codeacademy.spring2025.eshop.common.validation.annotation.phonenumber;

import java.lang.annotation.*;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import lt.codeacademy.spring2025.eshop.common.validation.annotation.phonenumber.impl.PhoneNumberValidator;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = { PhoneNumberValidator.class })
@NotBlank
public @interface PhoneNumber {
  String message() default "Phone number length must be 12 characters";

  Class<?>[] groups() default { };

  Class<? extends Payload>[] payload() default { };

  PhoneNumberPrefixType prefixType() default PhoneNumberPrefixType.GLOBAL;

  @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
  @Retention(RUNTIME)
  @Documented
  public @interface List {
    NotBlank[] value();
  }
}
