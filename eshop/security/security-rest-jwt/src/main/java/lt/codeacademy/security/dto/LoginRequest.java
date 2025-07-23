package lt.codeacademy.security.dto;

import lombok.Builder;

@Builder
public record LoginRequest(String username, String password) {
}
