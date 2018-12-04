package com.avsan.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.avsan.payload.UploadFileResponse;
import com.avsan.service.FileStorageService;

@RestController
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileStorageService fileStorageService;
    
    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file,HttpServletRequest request, HttpServletResponse response) {
        String fileName = fileStorageService.storeFile(file);
        logger.info("File Name : ",fileName);
        return new UploadFileResponse(fileName,
                file.getContentType(), file.getSize());
    }
    

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files,HttpServletRequest request, HttpServletResponse response) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file,request,response))
                .collect(Collectors.toList());
    }
}
