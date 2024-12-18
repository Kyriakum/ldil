package com.kyriakum.ldil.core.providers.strategy.registry;

import com.kyriakum.ldil.core.providers.strategy.InstanceProviderStrategy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

public final class StrategyRegistry implements IStrategyRegistry {

    private final Map<Class<? extends Annotation>, InstanceProviderStrategy> strategyMap = new HashMap<>();

    public void registerStrategy(@NotNull final Class<? extends Annotation> annotationType, @NotNull final InstanceProviderStrategy strategySupplier){
        strategyMap.putIfAbsent(annotationType,strategySupplier);
    }

    public @Nullable InstanceProviderStrategy getStrategyByAnnotation(@NotNull final Class<? extends Annotation> annotation){
        return strategyMap.get(annotation);
    }
}
