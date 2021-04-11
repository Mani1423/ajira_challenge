package com.ajirasoft.challenge.services;

import com.ajirasoft.challenge.common.AppErrorCode;
import com.ajirasoft.challenge.common.AppException;
import com.ajirasoft.challenge.common.Config;
import com.ajirasoft.challenge.common.DataHelper;
import com.ajirasoft.challenge.core.Executor;
import com.ajirasoft.challenge.core.ExecutorFactory;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AppService {

    private final String INPUTDELIMITER = "|";

    public Boolean execute(String inputFilePath, String configurationPath, String outputPath) {
        Boolean isProcessed = true;
        try {
            // Read and load the configuration and identify the process
            validateFilePath(inputFilePath);
            validateFilePath(configurationPath);
            List<Config> configs = loadConfigurations(configurationPath);

            for(Config config : configs) {
               Executor executor = ExecutorFactory.getExecutor(config.getProcessName());
               List<String> data = executor.execute(inputFilePath, config, outputPath, INPUTDELIMITER);
               writeData(outputPath, data);
            }


        } catch (AppException ex) {
            ex.printStackTrace();
            isProcessed = false;
        }
        return isProcessed;
    }


    private void validateFilePath(String inputFilePath) {
        // Validate the existence of input and configuration files
        if(Objects.isNull(inputFilePath) || inputFilePath.isEmpty()) {
            throw new AppException(AppErrorCode.PATH_INVALID);
        }
        Path filePath = Paths.get(inputFilePath);
        if(!filePath.toFile().exists()) {
            throw new AppException(AppErrorCode.FILE_NOT_FOUND, inputFilePath);
        }
    }

    private List<Config> loadConfigurations(String configurationPath) {
        AppFileHandler fileHandler = new AppFileHandler();
        List<Config> configs = new ArrayList<>();
        String data = "";
        try(BufferedReader reader = fileHandler.getFileReader(configurationPath)) {
            Map<String, Integer> headerMap = DataHelper.getHeaderMap(reader.readLine(), INPUTDELIMITER);
            data = reader.readLine();
            while (null != data) {
                String[] values = DataHelper.getDataFromLine(data, INPUTDELIMITER);
                int stepIndex = headerMap.get("step");
                int columnChangeIndex = headerMap.get("column_change_type");
                int oldColumnIndex = headerMap.get("old_column");
                int newColumnIndex = headerMap.get("new_column");
                String stepName = values[stepIndex];
                List<String> formats = new ArrayList<>();

                // Ignore first 4 static configuration columns
                for(int i = 4; i < headerMap.size(); i++) {
                    formats.add(values[i]);
                }
                configs.add(new Config(stepName, values[columnChangeIndex], values[oldColumnIndex], values[newColumnIndex], formats));
                data = reader.readLine();
            }
        } catch (IOException ex) {
            throw new AppException(AppErrorCode.FILE_READ_FAILED, configurationPath);
        }
        return configs;
    }

    private void writeData(String path, List<String> data) {
        AppFileHandler fileHandler = new AppFileHandler();
        try(Writer writer = fileHandler.getFileWriter(path)) {
            writer.write(String.join(System.lineSeparator(), data));
        } catch (IOException ex) {
            throw new AppException(AppErrorCode.FILE_WRITE_FAILED, path);
        }
    }
}
