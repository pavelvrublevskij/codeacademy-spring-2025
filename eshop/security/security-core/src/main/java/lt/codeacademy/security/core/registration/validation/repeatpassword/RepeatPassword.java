package lt.codeacademy.spring2025.security.core.registration.validation.repeatpassword;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import lt.codeacademy.spring2025.security.core.registration.validation.repeatpassword.impl.RepeatPasswordValidator;

/**
 * Custom annotation for validating that two password fields match.
 * <p>
 * This annotation can be applied to a class, and it will validate that the
 * password and passwordRepeat fields are equal.
 * </p>
 * <p>
 * Example usage:
 * </p>
 * <pre>
 * {@code
 * @RepeatPassword
 * public class UserSignUpDto {
 *     private String password;
 *     private String passwordRepeat;
 * }
 * }
 * </pre>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = { RepeatPasswordValidator.class })
public @interface RepeatPassword {
  String message() default "Passwords must match";

  Class<?>[] groups() default { };

  Class<? extends Payload>[] payload() default { };

  @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
  @Retention(RUNTIME)
  @Documented
  public @interface List {
    NotBlank[] value();
  }
}
