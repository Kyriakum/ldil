package com.kyriakum.ldil.core.providers.strategy.registry;

import com.kyriakum.ldil.core.providers.strategy.InstanceProviderStrategy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.annotation.Annotation;

public interface IStrategyRegistry {

    void registerStrategy(@NotNull final Class<? extends Annotation> annotationType, @NotNull final InstanceProviderStrategy strategySupplier);

    @Nullable InstanceProviderStrategy getStrategyByAnnotation(@NotNull final Class<? extends Annotation> annotation);

    }
