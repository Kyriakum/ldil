package com.kyriakum.ldil.core.providers.strategy;

import org.jetbrains.annotations.NotNull;

public interface InstanceProviderStrategy {
    <T> T provideInstance(@NotNull final Class<T> clasz);
}
