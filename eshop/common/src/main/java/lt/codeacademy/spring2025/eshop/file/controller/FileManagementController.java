package lt.codeacademy.spring2025.eshop.file.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.HttpEndpoint;
import lt.codeacademy.spring2025.eshop.file.FileService;

@Controller
@RequiredArgsConstructor
@RequestMapping(HttpEndpoint.FILE_UPLOAD)
public class FileManagementController {

  public static final String FILE_UPLOAD = "file/upload";
  private final FileService fileService;

  @GetMapping
  public String getUploadPage() {
    return FILE_UPLOAD;
  }

  @PostMapping
  public String uploadFile(@RequestParam MultipartFile file) {
    fileService.uploadFile(file);
    return "redirect:" + HttpEndpoint.FILE_UPLOAD;
  }
}
