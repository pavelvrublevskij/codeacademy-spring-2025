package lt.codeacademy.spring2025.eshop.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.file.FileService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/files")
public class FilesRestController {

  private final FileService fileService;

  @PostMapping("/upload")
  public ResponseEntity<Void> uploadFile(@RequestParam MultipartFile file) {
    // Method to handle file upload
    return ResponseEntity.ok().build();
  }
}
