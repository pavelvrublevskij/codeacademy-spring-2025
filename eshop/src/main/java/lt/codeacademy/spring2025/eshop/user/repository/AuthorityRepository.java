package lt.codeacademy.spring2025.eshop.user.repository;

import java.util.Optional;

import lt.codeacademy.spring2025.eshop.user.model.AuthorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<AuthorityEntity, Long> {

    Optional<AuthorityEntity> findByName(String name);
}
