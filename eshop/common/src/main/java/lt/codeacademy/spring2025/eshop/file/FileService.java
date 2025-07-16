package lt.codeacademy.spring2025.eshop.file;

import java.io.File;
import java.io.IOException;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

  private static final String UPLOAD_DIR = "./uploads";

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
    } catch (IOException e) {
      throw new RuntimeException("Failed to upload file: " + uniqueFilename, e);
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

  public MediaType getFileMediaTypeByFileName(final String fileName) {
    return MediaType.valueOf(URLConnection.guessContentTypeFromName(fileName));
  }
}