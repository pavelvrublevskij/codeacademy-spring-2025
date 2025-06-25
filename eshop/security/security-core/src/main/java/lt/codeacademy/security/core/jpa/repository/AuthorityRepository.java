package lt.codeacademy.spring2025.security.core.jpa.repository;

import java.util.Optional;

import lt.codeacademy.spring2025.security.core.jpa.model.AuthorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<AuthorityEntity, Long> {

    Optional<AuthorityEntity> findByName(String name);
}
