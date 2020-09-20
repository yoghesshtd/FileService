package com.dbs.fileservice.FileService.controller;

import com.dbs.fileservice.FileService.bean.FileDetailsResponse;
import com.dbs.fileservice.FileService.services.FileApiService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@Slf4j
public class FileApiController {

    final FileApiService service;

    public FileApiController(FileApiService service) {
        this.service = service;
    }

    @GetMapping(value = "/all")
    public String getAllFiles(@RequestParam(name = "path", required = true, defaultValue = "c:\\") String path,
                              Model model) throws IOException {
        log.info("Inside file controller - getAllFiles - path value: {}", path);
        FileDetailsResponse response = service.getAllFiles(path);

        if (response.isSuccess()) {
            model.addAttribute("files", response.getData());
            return "files";
        } else {
            model.addAttribute("message", ArrayUtils.toString(response.getErrors()));
            model.addAttribute("comments", response.getErrorDescription());
            return "error";
        }
    }

    @GetMapping(value = "/attributes")
    public String getAttributes(@RequestParam(name = "filePath", required = true, defaultValue = "c:\\") String path,
                              Model model) throws IOException {
        log.info("Inside file controller - getAttributes - path value: {}", path);
        FileDetailsResponse response = service.getAttributes(path);

        if (response.isSuccess()) {
            model.addAttribute("files", response.getData());
            return "attributes";
        } else {
            model.addAttribute("message", ArrayUtils.toString(response.getErrors()));
            model.addAttribute("comments", response.getErrorDescription());
            return "error";
        }
    }
}
