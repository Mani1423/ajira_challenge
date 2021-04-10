package com.ajirasoft.challenge.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHelper {

    public static boolean deleteFile(String path) throws IOException {
        Path filePath = Paths.get(path);
        boolean isDeleted = false;
        if (filePath.toFile().exists()) {
            Files.delete(Paths.get(path));
            isDeleted = true;
        }
        return isDeleted;
    }
}
