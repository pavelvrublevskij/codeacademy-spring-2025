package lt.codeacademy.security.provider;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import jakarta.annotation.PostConstruct;

import javax.crypto.KeyGenerator;

import lombok.Getter;
import lt.codeacademy.security.core.dto.UserRoleDto;

@Component
public class JwtProvider {

  private static final Map<String, Object> HEADER_MAP;
  public static final String ESHOP_API = "eshop-api";
  public static final String ROLES_CLAIM = "roles";

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
      .withIssuer(ESHOP_API)
      .withAudience(ESHOP_API)
      .withSubject(userRoleDto.getUsername())
      .withClaim(ROLES_CLAIM, userRoleDto.getAuthorities().stream()
        .map(GrantedAuthority::getAuthority)
        .toList())
      .withIssuedAt(now)
      .withExpiresAt(new Date(now.getTime() + tokenValidityInMillis))
      .sign(createAlgorithmBySecretKey());
  }

  @PostConstruct
  protected void init() throws NoSuchAlgorithmException {
    // Generate a random secret key for HMAC SHA-512
    secretKey = KeyGenerator.getInstance("HmacSHA512").generateKey().getEncoded();
  }

  public Long getTokenExpiresInSeconds() {
    return tokenValidityInMillis / 1000L;
  }

  public Authentication validateToken(final String token) {
    final JWTVerifier verifier = JWT.require(createAlgorithmBySecretKey())
      .withIssuer(ESHOP_API)
      .withAudience(ESHOP_API)
      .build();

    final DecodedJWT decodedJWT = verifier.verify(token);

    if (decodedJWT != null) {
      final Claim claim = decodedJWT.getClaim(ROLES_CLAIM);
      final List<SimpleGrantedAuthority> authorities = claim.asList(SimpleGrantedAuthority.class);

      return new UsernamePasswordAuthenticationToken(decodedJWT.getSubject(), null, authorities);
    }

    return null;
  }

  private Algorithm createAlgorithmBySecretKey() {
    return Algorithm.HMAC512(secretKey);
  }
}
