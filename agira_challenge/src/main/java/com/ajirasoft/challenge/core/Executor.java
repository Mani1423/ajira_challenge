package com.ajirasoft.challenge.core;

import com.ajirasoft.challenge.common.Config;

import java.util.List;

public interface Executor {
    List<String> execute(String inputFile, Config config, String outputFile, String delimiter);
}
