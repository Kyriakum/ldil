package com.kyriakum.ldil.utils;

public final class InternalsConfig {

    public static final String STRATEGY_PATH;

    static {
        ConfigLoader configLoader = new ConfigLoader("internals.properties");
        STRATEGY_PATH = configLoader.getProperty("strategy_path");
    }
}
