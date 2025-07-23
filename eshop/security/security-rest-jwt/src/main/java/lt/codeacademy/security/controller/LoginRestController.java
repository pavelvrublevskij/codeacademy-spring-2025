package lt.codeacademy.security.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.security.core.dto.UserRoleDto;
import lt.codeacademy.security.dto.LoginRequest;
import lt.codeacademy.security.dto.LoginResponse;
import lt.codeacademy.security.provider.JwtProvider;

@RestController
@RequiredArgsConstructor
public class LoginRestController {

  private final JwtProvider jwtProvider;
  private final AuthenticationManager authenticationManager;

  @PostMapping("/api/login")
  public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
    return Optional.of(authenticate(loginRequest))
      .map(auth -> (UserRoleDto) auth.getPrincipal())
      .map(principalDto ->
        ResponseEntity.ok(new LoginResponse(principalDto.getUsername(), jwtProvider.createToken(principalDto))))
      .orElseThrow(() -> new BadCredentialsException("Authentication failed!"));
  }

  private Authentication authenticate(LoginRequest loginRequest) {
    return authenticationManager.authenticate(
      UsernamePasswordAuthenticationToken.unauthenticated(loginRequest.username(), loginRequest.password()));
  }
}
