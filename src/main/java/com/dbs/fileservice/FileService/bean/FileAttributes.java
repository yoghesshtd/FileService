package com.dbs.fileservice.FileService.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class FileAttributes implements Serializable {
    private static final long serialVersionUID = -8579368344420252985L;

    private long size;
    private boolean isDirectory;
    private String createdBy;
    private String createdTime;
    private String modifiedBy;
    private String modifiedTime;
    private boolean read;
    private boolean execute;
    private String permissions;
    private String owner;
    private String group;

    @Override
    public String toString() {
        return "FileAttributes{" +
                "size=" + size +
                ", isDirectory=" + isDirectory +
                ", createdBy='" + createdBy + '\'' +
                ", createdTime='" + createdTime + '\'' +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", modifiedTime='" + modifiedTime + '\'' +
                ", read='" + read + '\'' +
                ", execute='" + execute + '\'' +
                ", permissions='" + permissions + '\'' +
                ", owner='" + owner + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}
