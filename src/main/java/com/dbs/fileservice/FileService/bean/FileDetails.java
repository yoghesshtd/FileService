package com.dbs.fileservice.FileService.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class FileDetails implements Serializable {
    private static final long serialVersionUID = 7960623146793520653L;

    private String name;
    private String path;
    private FileAttributes attributes;
    private String comments;

    @Override
    public String toString() {
        return "FileDetails{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", attributes=" + attributes +
                ", comments='" + comments + '\'' +
                '}';
    }
}
