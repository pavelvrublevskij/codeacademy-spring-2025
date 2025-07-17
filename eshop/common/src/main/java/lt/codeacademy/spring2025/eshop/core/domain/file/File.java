package lt.codeacademy.spring2025.eshop.core.domain.file;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class File {

  private String name;
  private String extension;
  private String contentType;
  private long size;
  private LocalDateTime createdAt;

  public UUID getFileUuid() {
    return UUID.fromString(name.split("_")[0]);
  }
}
