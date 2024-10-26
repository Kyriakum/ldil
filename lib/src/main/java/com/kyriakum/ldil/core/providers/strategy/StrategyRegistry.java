package com.kyriakum.ldil.core.providers.strategy;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

public final class StrategyRegistry {

    private final Map<Class<? extends Annotation>, InstanceProviderStrategy> strategyMap = new HashMap<>();

    public void registerStrategy(@NotNull Class<? extends Annotation> annotationType, @NotNull InstanceProviderStrategy strategySupplier){
        strategyMap.putIfAbsent(annotationType,strategySupplier);
    }

    public @Nullable InstanceProviderStrategy getStrategyByAnnotation(@NotNull Class<? extends Annotation> annotation){
        return strategyMap.get(annotation);
    }
}
