package com.dbs.fileservice.FileService.services;

import com.dbs.fileservice.FileService.bean.FileDetails;
import com.dbs.fileservice.FileService.bean.FileDetailsResponse;
import com.dbs.fileservice.FileService.util.ApplicationUtil;
import com.dbs.fileservice.FileService.validator.FileValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class FileApiService {
    public FileDetailsResponse getAllFiles(String strPath) {
        final FileDetailsResponse response = new FileDetailsResponse();
        final List<FileDetails> lstFileDetails = new ArrayList<>();
        File inputFile = new File(strPath);
        boolean status = false;

        try {
            if (!FileValidator.validFile(strPath).isEmpty()) {
                response.setErrors(FileValidator.validFile(strPath));
                return response;
            }
            ApplicationUtil.getAllFiles(inputFile, lstFileDetails);
            if (!lstFileDetails.isEmpty()) {
                response.setData(lstFileDetails);
                status = true;
            }

        } catch(Exception e) {
            log.error("Exception occurred - getAllFiles - {}", e.getMessage());
            response.setErrorDescription("Failed!! Unable to list files, contact admin " + e.getMessage());
        }

        response.setSuccess(status);

        return response;
    }

    public FileDetailsResponse getAttributes(String strPath) {
        final FileDetailsResponse response = new FileDetailsResponse();
        final List<FileDetails> lstFileDetails = new ArrayList<>();
        final FileDetails fileDetails = new FileDetails();
        final File inputFile = new File(strPath);
        boolean status = false;

        try {
            if (!FileValidator.validFile(strPath).isEmpty()) {
                response.setErrors(FileValidator.validFile(strPath));
                return response;
            } else if (inputFile.isDirectory()){
                response.setErrorDescription("Input file is a directory, enter a valid file");
                return response;
            }

            fileDetails.setPath(inputFile.getParent());
            fileDetails.setName(inputFile.getName());

            ApplicationUtil.getFileAttributes(Paths.get(String.valueOf(inputFile)), fileDetails);
            lstFileDetails.add(fileDetails);

            if (!lstFileDetails.isEmpty()) {
                response.setData(lstFileDetails);
                status = true;
            }

        } catch(Exception e) {
            e.printStackTrace();
            log.error("Exception occurred - getAttributes - {}", e.getMessage());
            response.setErrorDescription("Failed!! Unable to list files, contact admin " + e.getMessage());
        }

        response.setSuccess(status);

        return response;
    }
}
