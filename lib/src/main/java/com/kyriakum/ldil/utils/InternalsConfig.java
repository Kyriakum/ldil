package com.kyriakum.ldil.utils;

import com.kyriakum.ldil.config.IConfigLoader;
import com.kyriakum.ldil.config.PropertiesConfigLoader;

public final class InternalsConfig {

    public static final String STRATEGY_PATH;

    static {
        IConfigLoader configLoader = new PropertiesConfigLoader("internals.properties");
        STRATEGY_PATH = configLoader.getItem("strategy_path");
    }
}
