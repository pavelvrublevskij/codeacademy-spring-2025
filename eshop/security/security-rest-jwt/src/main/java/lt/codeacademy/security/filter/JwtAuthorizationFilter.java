package lt.codeacademy.security.filter;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.security.provider.JwtProvider;

@RequiredArgsConstructor
public class JwtAuthorizationFilter extends OncePerRequestFilter {

  public static final String BEARER_PREFIX = "Bearer ";

  private final JwtProvider jwtProvider;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
    throws ServletException, IOException {
    final String authHeaderToken = request.getHeader(HttpHeaders.AUTHORIZATION);

    if (authHeaderToken != null && authHeaderToken.startsWith(BEARER_PREFIX)) {
      final String token = authHeaderToken.replaceAll(BEARER_PREFIX, "");

      final Authentication authentication = jwtProvider.validateToken(token);

      SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    filterChain.doFilter(request, response);
  }
}
