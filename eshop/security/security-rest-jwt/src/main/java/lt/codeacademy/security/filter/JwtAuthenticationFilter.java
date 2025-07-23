package lt.codeacademy.security.filter;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lt.codeacademy.security.dto.LoginRequest;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

  private final ObjectMapper objectMapper;

  public JwtAuthenticationFilter(AuthenticationManager authenticationManager, ObjectMapper objectMapper) {
    super(authenticationManager);
    this.objectMapper = objectMapper;
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
    try {
      final LoginRequest loginRequest = objectMapper.readValue(request.getReader(), LoginRequest.class);

      var authRequest = UsernamePasswordAuthenticationToken.unauthenticated(loginRequest.username(), loginRequest.password());

      // Allow subclasses to set the "details" property
      setDetails(request, authRequest);
      return this.getAuthenticationManager().authenticate(authRequest);
    } catch (IOException e) {
      throw new RuntimeException("Unable to parse payload credentials");
    }
  }

  @Override
  protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
    throws IOException, ServletException {
    response.addHeader(HttpHeaders.AUTHORIZATION, "Cia bus mano tokenas...");
  }
}
