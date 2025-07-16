package lt.codeacademy.spring2025.eshop.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

  private static final String UPLOAD_DIR = "./uploads";

  public void uploadFile(final MultipartFile file) {
    try {
      // Create the upload directory if it doesn't exist
      final Path fileLocation = Paths.get(UPLOAD_DIR).toAbsolutePath().normalize();
      if (!Files.exists(fileLocation)) {
        Files.createDirectories(fileLocation);
      }

      file.transferTo(new File(fileLocation + "/" + file.getOriginalFilename()));
    } catch (IOException e) {
      throw new RuntimeException("Failed to upload file: " + file.getOriginalFilename(), e);
    }
  }

  public ByteArrayResource download(final String fileName) {
    final Path filePath = Paths.get(UPLOAD_DIR, fileName).toAbsolutePath().normalize();
    try {
      return new ByteArrayResource(Files.readAllBytes(filePath));
    } catch (IOException e) {
      throw new RuntimeException("Failed to read file: " + fileName, e);
    }
  }
}