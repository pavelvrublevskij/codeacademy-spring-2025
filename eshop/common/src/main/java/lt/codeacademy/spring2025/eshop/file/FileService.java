package lt.codeacademy.spring2025.eshop.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

  private static final String UPLOAD_DIR = "./uploads";

  public void uploadFile(final MultipartFile file) throws IOException {
    // Create the upload directory if it doesn't exist
    final Path fileLocation = Paths.get(UPLOAD_DIR).toAbsolutePath().normalize();
    if (!Files.exists(fileLocation)) {
      Files.createDirectories(fileLocation);
    }

    file.transferTo(new File(fileLocation + "/" + file.getOriginalFilename()));
  }
}