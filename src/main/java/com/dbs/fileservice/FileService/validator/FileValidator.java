package com.dbs.fileservice.FileService.validator;

import com.dbs.fileservice.FileService.bean.Error;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileValidator {
    public static List<Error> validFile(String strInput) {
        File inputFile = new File(strInput);
        final List<Error> lstError = new ArrayList<>();
        Error error;

        if (!inputFile.exists()) {
            error = new Error();

            error.setMessage("File / Directory doesn't exist");
            lstError.add(error);
        }

        return lstError;
    }

}
