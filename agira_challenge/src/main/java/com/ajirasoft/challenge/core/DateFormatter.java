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
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.SimpleFormatter;

public class DateFormatter implements Executor {
    @Override
    public List<String> execute(String inputFile, Config config, String outputFile, String delimiter) {
        AppFileHandler fileHandler = new AppFileHandler();
        List<String> outputData = new ArrayList<>();
        List<String> formats = config.getFormats();
        SimpleDateFormat inputFormat = new SimpleDateFormat(formats.get(0));
        SimpleDateFormat format = new SimpleDateFormat(formats.get(1));
        try(BufferedReader reader = fileHandler.getFileReader(inputFile)) {
            String data = reader.readLine();
            Map<String, Integer> headerMap = DataHelper.getHeaderMap(data, delimiter);
            outputData.add(DataHelper.columnReplacer(data, delimiter, config));
            data = reader.readLine();
            while (null != data) {
                String[] values = DataHelper.getDataFromLine(data, delimiter);
                String dob = values[headerMap.get(config.getOldColumn())];
                Date date = inputFormat.parse(dob);
                List<String> outputValues = new ArrayList<>();
                outputValues.add(values[headerMap.get("name")]);
                outputValues.add(format.format(date));
                outputData.add(String.join(delimiter, outputValues));
                data = reader.readLine();
            }

        } catch (IOException | ParseException ex) {
            throw new AppException(AppErrorCode.FILE_READ_FAILED, inputFile);
        }
        return outputData;
    }
}
