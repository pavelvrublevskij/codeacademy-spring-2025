package lt.codeacademy.spring2025.eshop.file.dto;

import org.springframework.util.unit.DataSize;
import lombok.Builder;

@Builder
public record FileDto(String fileName, long size) {

  public String getReadableSize() {
    return DataSize.ofBytes(size).toMegabytes() + " MB";
  }
}
