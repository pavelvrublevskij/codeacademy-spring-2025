package lt.codeacademy.spring2025.eshop.file.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import lt.codeacademy.spring2025.eshop.file.model.FileEntity;

public interface FileRepository extends JpaRepository<FileEntity, Long> {
}
