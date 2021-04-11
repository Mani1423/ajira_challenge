package com.ajirasoft.challenge.common;

import java.util.*;
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
    public static String columnReplacer(String header, String delimiter, Config config) {
        List<String> headers = new LinkedList<>(Arrays.asList(getDataFromLine(header, delimiter)));
        switch (config.getColumnChangeType()) {
            case "ADD":
                List<String> newColumns = Arrays.asList(config.getNewColumn().split(":"));
                headers.addAll(newColumns);
                break;
            case "DELETE":
                List<String> oldColumns = Arrays.asList(config.getOldColumn().split(":"));
                headers.removeAll(oldColumns);
                break;
            case "REPLACE":
                oldColumns = Arrays.asList(config.getOldColumn().split(":"));
                newColumns = Arrays.asList(config.getNewColumn().split(":"));
                for(int i = 0; i < oldColumns.size(); i++) {
                    int index = headers.indexOf(oldColumns.get(i));
                    if(newColumns.size() > i && !headers.contains(newColumns.get(i))) {
                        headers.set(index, newColumns.get(i));
                    } else {
                        headers.remove(index);
                    }
                }
               break;
            default:
                break;

        }
        return String.join(delimiter, headers);
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
