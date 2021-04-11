package com.ajirasoft.challenge.common;

import java.util.List;

public class Config {

    private String processName;
    private String columnChangeType;
    private String oldColumn;
    private String newColumn;
    private List<String> formats;

    public Config(String processName, List<String> formats) {
        this.processName = processName;
        this.formats = formats;
    }

    public Config(String processName, String columnChangeType, String oldColumn, String newColumn, List<String> formats) {
        this.processName = processName;
        this.columnChangeType = columnChangeType;
        this.oldColumn = oldColumn;
        this.newColumn = newColumn;
        this.formats = formats;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getColumnChangeType() {
        return columnChangeType;
    }

    public void setColumnChangeType(String columnChangeType) {
        this.columnChangeType = columnChangeType;
    }

    public String getOldColumn() {
        return oldColumn;
    }

    public void setOldColumn(String oldColumn) {
        this.oldColumn = oldColumn;
    }

    public String getNewColumn() {
        return newColumn;
    }

    public void setNewColumn(String newColumn) {
        this.newColumn = newColumn;
    }

    public List<String> getFormats() {
        return formats;
    }

    public void setFormats(List<String> formats) {
        this.formats = formats;
    }
}
