package com.ajirasoft.challenge.services;

import com.ajirasoft.challenge.common.AppErrorCode;
import com.ajirasoft.challenge.common.AppException;
import com.ajirasoft.challenge.common.FileHelper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AppFileHandler {

    public BufferedReader getFileReader(String path) throws FileNotFoundException {
            FileReader inputFile = new FileReader(path);
            return new BufferedReader(inputFile);
    }

    public Writer getFileWriter(String path) throws IOException {
        Path finalPath = Paths.get(path);
        if (!finalPath.getParent().toFile().exists()) {
            Files.createDirectories(finalPath.getParent());
        }
        return new FileWriter(path, false);
    }
//
//    private boolean create(String filePath) throws IOException {
//        File file = new File(filePath);
//        if (!file.getParentFile().exists()) {
//            file.getParentFile().mkdirs();
//        }
//        FileHelper.deleteFile(filePath);
//        boolean created = file.createNewFile();
//        return created;
//    }
}
