package com.kyriakum.ldil.core.providers.strategy;

import com.kyriakum.ldil.annotations.objecttype.Singleton;
import com.kyriakum.ldil.annotations.strategy.StrategySupported;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@StrategySupported(Singleton.class)
public final class SingletonProviderStrategy implements InstanceProviderStrategy {

    private final Map<Class<?>, Object> singletonMap = new HashMap<>();

    @Override
    public <T> T provideInstance(@NotNull Class<T> clasz) {
        return (T) singletonMap.computeIfAbsent(clasz, this::instantiate);
    }

    public <T> T instantiate(@NotNull Class<T> clasz) {
        try {
            return clasz.getDeclaredConstructor().newInstance();
        } catch (InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);

        }
    }
}
