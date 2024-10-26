package com.kyriakum.ldil.utils;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigLoader {

    private final Properties properties = new Properties();

    public ConfigLoader(@NotNull String fileName){
        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName)){
            if(inputStream == null){
                throw new RuntimeException("Unable to find file " + fileName);
            }
            properties.load(inputStream);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public String getProperty(@NotNull String key){
        return properties.getProperty(key);
    }
}
