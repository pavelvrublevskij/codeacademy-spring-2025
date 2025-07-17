package lt.codeacademy.spring2025.eshop.file;

import java.io.File;
import java.io.IOException;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.file.model.FileEntity;
import lt.codeacademy.spring2025.eshop.file.repository.FileRepository;

@Service
@RequiredArgsConstructor
public class FileService {

  private static final String UPLOAD_DIR = "./uploads";

  private final FileRepository fileRepository;

  @Transactional
  public void uploadFile(final MultipartFile file) {
    final String originalFilename = file.getOriginalFilename();
    final String uniqueFilename = UUID.randomUUID() + "_" + originalFilename;

    try {
      // Create the upload directory if it doesn't exist
      final Path fileLocation = Paths.get(UPLOAD_DIR).toAbsolutePath().normalize();
      if (!Files.exists(fileLocation)) {
        Files.createDirectories(fileLocation);
      }

      file.transferTo(new File(fileLocation + "/" + uniqueFilename));

      saveFileInfoToDatabase(file, uniqueFilename);
    } catch (IOException e) {
      throw new RuntimeException("Failed to upload file: " + uniqueFilename, e);
    }
  }

  private void saveFileInfoToDatabase(final MultipartFile file, final String uniqueFilename) {
    fileRepository.save(FileEntity.builder()
      .name(uniqueFilename)
      .contentType(file.getContentType())
      .size(file.getSize())
      .extension(getFIleExtension(file.getOriginalFilename()))
      .createdAt(LocalDateTime.now())
      .build());
  }

  private String getFIleExtension(final String originalFilename) {
    final String[] filenameData = originalFilename.split("\\.");
    if (filenameData.length > 1) {
      return filenameData[filenameData.length - 1];
    }

    return "";
  }

  public ByteArrayResource download(final String fileName) {
    final Path filePath = Paths.get(UPLOAD_DIR, fileName).toAbsolutePath().normalize();
    try {
      return new ByteArrayResource(Files.readAllBytes(filePath));
    } catch (IOException e) {
      throw new RuntimeException("Failed to read file: " + fileName, e);
    }
  }

  public MediaType getFileMediaTypeByFileName(final String fileName) {
    return MediaType.valueOf(URLConnection.guessContentTypeFromName(fileName));
  }
}