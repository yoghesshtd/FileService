package com.dbs.fileservice.FileService.util;

import com.dbs.fileservice.FileService.FileServiceUnCheckedException;
import com.dbs.fileservice.FileService.bean.FileAttributes;
import com.dbs.fileservice.FileService.bean.FileDetails;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.SystemUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.PosixFileAttributes;
import java.util.List;

@Slf4j
public class ApplicationUtil {

    public static void getAllFiles(File directory, List<FileDetails> lstFileDetails) throws FileServiceUnCheckedException{
        File[] files = directory.listFiles();
        if (null == files) return;

        for (File file : files) {
            if (null == file) continue;
            FileDetails fileDetails = new FileDetails();

            fileDetails.setName(file.getName());
            fileDetails.setPath(file.getParent());

            Path path = Paths.get(file.getPath());
            getFileAttributes(path, fileDetails);
            // System.out.println(fileDetails);
            lstFileDetails.add(fileDetails);

            if (file.isDirectory()) {
                // System.out.println("directory:" + file.getCanonicalPath());
                getAllFiles(file, lstFileDetails);
            }
        }
    }

    public static void getFileAttributes(Path strFile, FileDetails fileDetails) {
        BasicFileAttributes attrs = null;
        FileAttributes fileAttributes = new FileAttributes();

        try {
            if (SystemUtils.IS_OS_WINDOWS) {
                attrs = Files.readAttributes(strFile, BasicFileAttributes.class);
            } else if (SystemUtils.IS_OS_LINUX) {
                attrs = Files.readAttributes(strFile, PosixFileAttributes.class);

                fileAttributes.setOwner(((PosixFileAttributes) attrs).owner().toString());
                fileAttributes.setGroup(((PosixFileAttributes) attrs).group().toString());
                fileAttributes.setPermissions(((PosixFileAttributes) attrs).permissions().toString());
            }

            fileAttributes.setDirectory(attrs.isDirectory());
            fileAttributes.setSize(attrs.size());
            fileAttributes.setCreatedTime(attrs.creationTime().toString());
            fileAttributes.setModifiedTime(attrs.creationTime().toString());
            fileAttributes.setRead(strFile.toFile().canRead());
            fileAttributes.setExecute(strFile.toFile().canExecute());

            fileDetails.setAttributes(fileAttributes);
        } catch (IOException e) {
            log.error("Exception occurred - getFileAttributes - {}", e.getMessage());
            fileDetails.setComments("Unable to get file attributes");
        }
    }
}
