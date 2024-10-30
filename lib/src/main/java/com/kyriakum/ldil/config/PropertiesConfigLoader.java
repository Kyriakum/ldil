package com.kyriakum.ldil.config;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesConfigLoader implements IConfigLoader {

    private final Properties properties = new Properties();

    public PropertiesConfigLoader(@NotNull final String fileName){
        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName)){
            if(inputStream == null){
                throw new RuntimeException("Unable to find file " + fileName);
            }
            properties.load(inputStream);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public String getItem(@NotNull final String key){
        return properties.getProperty(key);
    }
}
