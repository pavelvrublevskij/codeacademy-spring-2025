package lt.codeacademy.spring2025.security.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.security.core.registration.dto.UserSignUpDto;
import lt.codeacademy.security.core.registration.service.UserRegistrationService;
import lt.codeacademy.security.core.registration.validator.UserSignupValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(UserController.USERS_SIGN_UP)
@RequiredArgsConstructor
public class UserController {

  protected static final String USERS_SIGN_UP = "/users/sign-up";
  public static final String USER_SIGN_UP_VIEW = "user/userSignUp";

  private final MessageService messageService;
  private final UserSignupValidator userSignupValidator;
  private final UserRegistrationService userRegistrationService;

  @GetMapping
  public String getSignUpForm(Model model) {
    model.addAttribute("userSignUpDto", UserSignUpDto.builder().build());
    return USER_SIGN_UP_VIEW;
  }

  @PostMapping
  public String createUser(@Valid UserSignUpDto userSignUpDto, BindingResult error, Model model, RedirectAttributes redirectAttributes) {
    userSignupValidator.validate(userSignUpDto, error);
    if (error.hasErrors()) {
      return USER_SIGN_UP_VIEW;
    }

    userRegistrationService.createUser(userSignUpDto);

    redirectAttributes.addFlashAttribute("message", messageService.getTranslatedMessage("user.signup.message.success"));
    return "redirect:" + USERS_SIGN_UP;
  }
}
