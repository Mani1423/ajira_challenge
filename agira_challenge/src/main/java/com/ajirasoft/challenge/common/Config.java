package com.ajirasoft.challenge.common;

import java.util.List;

public class Config {

    private String processName;
    private List<String> formats;

    public Config(String processName, List<String> formats) {
        this.processName = processName;
        this.formats = formats;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public List<String> getFormats() {
        return formats;
    }

    public void setFormats(List<String> formats) {
        this.formats = formats;
    }
}
