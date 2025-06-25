package lt.codeacademy.spring2025.security.core.jpa.repository;

import java.util.Optional;

import lt.codeacademy.spring2025.security.core.jpa.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

  // JPQL - java persistence query language
  @Query(value = "SELECT u FROM UserEntity u" +
    " JOIN FETCH u.authorities" +
    " WHERE u.email = :email")
  // SQL - structured query language
//  @Query(value = "SELECT * FROM users u " +
//    " join users_authorities ua ON ua.user_id = u.id" +
//    " join authority a ON a.id = ua.authority_id" +
//    " where u.email=:email", nativeQuery = true)
  Optional<UserEntity> findUserByEmailWithAuthorities(String email);
}
