package lt.codeacademy.spring2025.eshop.user.repository;

import java.util.Optional;

import lt.codeacademy.spring2025.eshop.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

  Optional<UserEntity> findByEmail(String email);
}
