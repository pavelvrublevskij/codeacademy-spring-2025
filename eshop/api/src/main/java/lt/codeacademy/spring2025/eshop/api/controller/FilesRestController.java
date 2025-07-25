package lt.codeacademy.spring2025.eshop.api.controller;

import java.io.IOException;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
  public ResponseEntity<String> uploadFile(@RequestParam MultipartFile file) {
    fileService.uploadFile(file);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/download")
  public ResponseEntity<ByteArrayResource> downloadFile(@RequestParam String fileName) {
    final HttpHeaders headers = new HttpHeaders();
    headers.setContentDispositionFormData("attachment", fileName);
    headers.setContentType(fileService.getFileMediaTypeByFileName(fileName));

    return ResponseEntity.ok()
      .headers(headers)
      .body(fileService.download(fileName));
  }
}
