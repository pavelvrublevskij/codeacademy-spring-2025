package lt.codeacademy.spring2025.eshop.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lt.codeacademy.spring2025.eshop.common.validation.PhoneNumber;

@Builder
public record UserSignUpDto(@NotBlank String name,
                            @NotBlank String surname,
                            @NotBlank String email,
                            @PhoneNumber String phoneNumber,
                            @NotBlank String zipCode,
                            @NotBlank String city,
                            @NotBlank String password,
                            @NotBlank String passwordRepeat) {}
