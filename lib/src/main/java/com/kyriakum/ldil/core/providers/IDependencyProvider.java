package com.kyriakum.ldil.core.providers;

import com.kyriakum.ldil.exceptions.StrategyInitializationException;
import org.jetbrains.annotations.NotNull;

public interface IDependencyProvider {

    <T> T provideDependency(@NotNull final Class<T> clasz) throws StrategyInitializationException;
}
