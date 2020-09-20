package com.dbs.fileservice.FileService.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class FileDetailsResponse implements Serializable {
    private static final long serialVersionUID = -3481974948863578175L;
    private List<FileDetails> data;
    private boolean success;
    private String errorDescription;
    private List<Error> errors;

    @Override
    public String toString() {
        return "FileDetailsResponse{" +
                "data=" + data +
                ", success=" + success +
                ", errorDescription='" + errorDescription + '\'' +
                ", errors=" + errors +
                '}';
    }
}
