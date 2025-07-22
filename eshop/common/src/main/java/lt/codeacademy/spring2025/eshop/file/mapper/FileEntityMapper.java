package lt.codeacademy.spring2025.eshop.file.mapper;

import org.springframework.stereotype.Component;
import lt.codeacademy.spring2025.eshop.common.mapper.DomainEntityMapper;
import lt.codeacademy.spring2025.core.domain.file.File;
import lt.codeacademy.spring2025.eshop.file.model.FileEntity;

@Component
public class FileEntityMapper implements DomainEntityMapper<File, FileEntity> {

  @Override
  public FileEntity toEntity(final File domain) {
    // TODO: implement this method when needed
    return null;
  }

  @Override
  public File toDomain(final FileEntity entity) {
    if (entity == null) {
      return null;
    }

    return File.builder()
        .name(entity.getName())
        .contentType(entity.getContentType())
        .size(entity.getSize())
        .extension(entity.getExtension())
        .createdAt(entity.getCreatedAt())
        .build();
  }
}
