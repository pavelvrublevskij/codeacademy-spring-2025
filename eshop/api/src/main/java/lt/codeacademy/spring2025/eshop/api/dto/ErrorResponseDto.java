package lt.codeacademy.spring2025.eshop.api.dto;

import lombok.Builder;

@Builder
public record ErrorResponseDto(int errorCode, String errorMessage) {
};
