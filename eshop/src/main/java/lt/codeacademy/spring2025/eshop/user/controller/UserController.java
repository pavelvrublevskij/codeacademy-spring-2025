package lt.codeacademy.spring2025.eshop.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.helper.MessageService;
import lt.codeacademy.spring2025.eshop.user.dto.UserSignUpDto;
import lt.codeacademy.spring2025.eshop.user.validator.UserSignupValidator;

import static lt.codeacademy.spring2025.eshop.HttpEndpoint.USERS_SIGN_UP;

@Controller
@RequestMapping(USERS_SIGN_UP)
@RequiredArgsConstructor
public class UserController {

  public static final String USER_SIGN_UP_VIEW = "user/userSignUp";

  private final MessageService messageService;
  private final UserSignupValidator userSignupValidator;

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

    redirectAttributes.addFlashAttribute("message", messageService.getTranslatedMessage("user.signup.message.success"));
    return "redirect:" + USERS_SIGN_UP;
  }
}
