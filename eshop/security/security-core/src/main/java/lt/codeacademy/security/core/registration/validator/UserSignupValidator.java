package lt.codeacademy.security.core.registration.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import lt.codeacademy.security.core.registration.dto.UserSignUpDto;

@Component
public class UserSignupValidator implements Validator {

  // look here for 99.99% email validation using regex https://emailregex.com/index.html
  public static final String EMAIL_REGEX = "^((?!\\.)[\\w\\-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$";

  @Override
  public boolean supports(Class<?> clazz) {
    return false;
  }

  @Override
  public void validate(Object target, Errors errors) {
    if (target instanceof UserSignUpDto) {
      final UserSignUpDto userSignUpDto = (UserSignUpDto) target;
        if (!isValidEmail(userSignUpDto.email())) {
          errors.rejectValue("email", "user.signup.email.invalid", "Invalid email format.");
        }
    }
  }

  private boolean isValidEmail(final String email) {
    final Pattern pattern = Pattern.compile(EMAIL_REGEX);
    final Matcher matcher = pattern.matcher(email);
    return matcher.matches();
  }
}
