package lt.codeacademy.spring2025.eshop.api.controller;

import java.io.IOException;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.file.FileService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/files")
public class FilesRestController {

  private final FileService fileService;

  @PostMapping("/upload")
  public ResponseEntity<String> uploadFile(@RequestParam MultipartFile file) {
    fileService.uploadFile(file);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/download")
  public ResponseEntity<ByteArrayResource> downloadFile(@RequestParam String fileName) {
    return ResponseEntity.ok()
      .contentType(fileService.getFileMediaTypeByFileName(fileName))
      .body(fileService.download(fileName));
  }
}
