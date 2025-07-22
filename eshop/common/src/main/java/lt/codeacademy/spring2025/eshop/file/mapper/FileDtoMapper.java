package lt.codeacademy.spring2025.eshop.file.mapper;

import org.springframework.stereotype.Component;
import lt.codeacademy.spring2025.eshop.common.mapper.DomainDtoMapper;
import lt.codeacademy.spring2025.core.domain.file.File;
import lt.codeacademy.spring2025.eshop.file.dto.FileDto;

@Component
public class FileDtoMapper implements DomainDtoMapper<File, FileDto> {

  @Override
  public FileDto toDto(final File domain) {
    if (domain == null) {
      return null;
    }

    return FileDto.builder()
        .fileName(domain.getName())
        .size(domain.getSize())
        .build();
  }

  @Override
  public File toDomain(final FileDto fileDto) {
    // TODO: implement this method when needed
    return null;
  }
}
