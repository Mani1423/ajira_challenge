package com.ajirasoft.challenge.core;

import com.ajirasoft.challenge.common.AppErrorCode;
import com.ajirasoft.challenge.common.AppException;
import com.ajirasoft.challenge.common.Config;
import com.ajirasoft.challenge.common.DataHelper;
import com.ajirasoft.challenge.services.AppFileHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class RemoveFilter implements Executor {
    @Override
    public List<String> execute(String inputFile, Config config, String outputFile, String delimiter) {
        AppFileHandler fileHandler = new AppFileHandler();
        List<String> outputData = new ArrayList<>();
        List<String> formats = config.getFormats();
        String condition = formats.get(0);
        Integer value = Integer.parseInt(formats.get(1));
        try(BufferedReader reader = fileHandler.getFileReader(inputFile)) {
            String data = reader.readLine();
            Map<String, Integer> headerMap = DataHelper.getHeaderMap(data, delimiter);
            outputData.add(DataHelper.columnReplacer(data, delimiter, config));
            data = reader.readLine();
            while (null != data) {
                String[] values = DataHelper.getDataFromLine(data, delimiter);
                Integer age = Integer.parseInt(values[headerMap.get("age")]);
                if("GREATER_THAN".equalsIgnoreCase(condition) && age < value) {
                    outputData.add(data);
                } else if ("LESS_THAN".equalsIgnoreCase(condition) && age > value) {
                    outputData.add(data);
                }
                data = reader.readLine();
            }

        } catch (IOException ex) {
            throw new AppException(AppErrorCode.FILE_READ_FAILED, inputFile);
        }
        return outputData;
    }
}
