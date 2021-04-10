package com.ajirasoft.challenge.common;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class DataHelper {

    public static String[] replaceDelimiters(String[] data) {
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replaceAll("[;,|]+", " ").replace("\"", "");
        }
        return data;
    }

    public static String[] getDataFromLine(String dataLine) {
        return dataLine.split("|(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
    }

    public static String[] getDataFromLine(String dataLine, String delimiter) {
        return dataLine.split(Pattern.quote(delimiter));
    }

    public static Map<String, Integer> getHeaderMap(String headerLine, String delimiter) {
        String[] headers = headerLine.split(Pattern.quote(delimiter));
        Map<String, Integer> headerMap = new LinkedHashMap<>();
        int index = 0;
        for (String header : headers) {
            headerMap.put(header.trim(), index);
            index++;
        }
        return headerMap;
    }
}
