package com.dbs.fileservice.FileService.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Error implements Serializable {

    private static final long serialVersionUID = 7188250077197594462L;

    private String code; // TODO
    private String message;

    @Override
    public String toString() {
        return "Error{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
