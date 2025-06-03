package lt.codeacademy.spring2025.eshop.user.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private String phoneNumber;
  private String address;
  private String city;
  private String zipCode;

  @ManyToMany(cascade = CascadeType.PERSIST)
  @JoinTable(
    name = "users_authorities",
    joinColumns = { @JoinColumn(name = "user_id") },
    inverseJoinColumns = { @JoinColumn(name = "authority_id") }
  )
  private Set<AuthorityEntity> authorities = new HashSet<>();

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return UserDetails.super.isAccountNonExpired();
  }

  @Override
  public boolean isAccountNonLocked() {
    return UserDetails.super.isAccountNonLocked();
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return UserDetails.super.isCredentialsNonExpired();
  }

  @Override
  public boolean isEnabled() {
    return UserDetails.super.isEnabled();
  }
}
