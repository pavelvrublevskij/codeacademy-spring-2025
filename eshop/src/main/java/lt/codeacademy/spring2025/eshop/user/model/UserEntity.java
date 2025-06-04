package lt.codeacademy.spring2025.eshop.user.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

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
}
