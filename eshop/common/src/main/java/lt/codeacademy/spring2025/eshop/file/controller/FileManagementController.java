package lt.codeacademy.spring2025.eshop.file.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.HttpEndpoint;
import lt.codeacademy.spring2025.eshop.file.FileService;
import lt.codeacademy.spring2025.eshop.file.dto.FileDto;
import lt.codeacademy.spring2025.eshop.file.mapper.FileDtoMapper;

@Controller
@RequiredArgsConstructor
@RequestMapping(HttpEndpoint.FILE_UPLOAD)
public class FileManagementController {

  public static final String FILE_UPLOAD = "file/upload";
  private final FileService fileService;
  private final FileDtoMapper fileDtoMapper;

  @GetMapping
  public String getUploadPage(Model model) {
    final List<FileDto> files = fileService.getAllFiles().stream()
        .map(fileDtoMapper::toDto)
        .toList();

    model.addAttribute("files", files);

    return FILE_UPLOAD;
  }

  @PostMapping
  public String uploadFile(@RequestParam MultipartFile file) {
    fileService.uploadFile(file);
    return "redirect:" + HttpEndpoint.FILE_UPLOAD;
  }
}
