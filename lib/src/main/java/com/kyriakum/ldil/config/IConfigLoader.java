package com.kyriakum.ldil.config;

import org.jetbrains.annotations.NotNull;

public interface IConfigLoader {
    String getItem(@NotNull final String key);
}
