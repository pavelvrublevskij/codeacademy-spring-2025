package lt.codeacademy.spring2025.eshop.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record UserSignUpDto(@NotBlank String name,
                            @NotBlank String surname,
                            @NotBlank String email,
                            @NotBlank String zipCode,
                            @NotBlank String city,
                            @NotBlank String password,
                            @NotBlank String passwordRepeat) {}
