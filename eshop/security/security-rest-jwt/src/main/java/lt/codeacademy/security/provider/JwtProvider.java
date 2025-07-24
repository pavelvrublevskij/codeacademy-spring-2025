package lt.codeacademy.security.provider;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.annotation.PostConstruct;

import javax.crypto.KeyGenerator;

import lombok.Getter;
import lt.codeacademy.security.core.dto.UserRoleDto;

@Component
public class JwtProvider {

  private static final Map<String, Object> HEADER_MAP;

  @Getter
  @Value("#{${spring.security.jwt.validity-time-in-minutes} * 60 * 1000}")
  private long tokenValidityInMillis;

  private byte[] secretKey;

  static {
    HEADER_MAP = new HashMap<>();
    HEADER_MAP.put("typ", "JWT");
  }

  public String createToken(final UserRoleDto userRoleDto) {
    final Date now = new Date();

    return JWT.create()
      .withHeader(HEADER_MAP)
      .withIssuer("eshop-api")
      .withAudience("eshop-api")
      .withSubject(userRoleDto.getUsername())
      .withClaim("roles", userRoleDto.getAuthorities().stream()
        .map(GrantedAuthority::getAuthority)
        .toList())
      .withIssuedAt(now)
      .withExpiresAt(new Date(now.getTime() + tokenValidityInMillis))
      .sign(Algorithm.HMAC512(secretKey));
  }

  @PostConstruct
  protected void init() throws NoSuchAlgorithmException {
    // Generate a random secret key for HMAC SHA-512
    secretKey = KeyGenerator.getInstance("HmacSHA512").generateKey().getEncoded();
  }

  public Long getTokenExpiresInSeconds() {
    return tokenValidityInMillis / 1000L;
  }
}
