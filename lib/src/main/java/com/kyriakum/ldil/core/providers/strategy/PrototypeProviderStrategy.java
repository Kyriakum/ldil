package com.kyriakum.ldil.core.providers.strategy;

import com.kyriakum.ldil.annotations.objecttype.Prototype;
import com.kyriakum.ldil.annotations.strategy.StrategySupported;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationTargetException;

@StrategySupported(Prototype.class)
public final class PrototypeProviderStrategy implements InstanceProviderStrategy {

    @Override
    public <T> T provideInstance(@NotNull Class<T> clasz) {
        try {
            return clasz.getDeclaredConstructor().newInstance();
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
