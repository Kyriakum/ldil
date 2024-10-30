package com.kyriakum.ldil.core.providers.strategy;

import com.kyriakum.ldil.annotations.objecttype.Prototype;
import com.kyriakum.ldil.annotations.strategy.StrategySupported;
import com.kyriakum.ldil.core.providers.strategy.registry.IStrategyRegistry;
import com.kyriakum.ldil.core.providers.strategy.registry.StrategyRegistry;
import com.kyriakum.ldil.utils.InternalsConfig;
import org.jetbrains.annotations.NotNull;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public final class StrategyLoader {

    public static void loadStrategies(@NotNull final IStrategyRegistry registry){

        Reflections reflections = new Reflections(InternalsConfig.STRATEGY_PATH);

        Set<Class<? extends InstanceProviderStrategy>> strategyClasses = reflections.getSubTypesOf(InstanceProviderStrategy.class);
        for(Class<? extends InstanceProviderStrategy> clasz : strategyClasses){
            if(clasz.isAnnotationPresent(StrategySupported.class)){
                Class<? extends Annotation> annotation = clasz.getAnnotation(StrategySupported.class).value();
                registry.registerStrategy(annotation, createStrategy(clasz));
            } else {
                // If no available annotation, default to prototype.
                registry.registerStrategy(Prototype.class, createStrategy(clasz));
            }
        }
    }

    private static InstanceProviderStrategy createStrategy(@NotNull final Class<? extends InstanceProviderStrategy> strategyType){
        try {
            return strategyType.getDeclaredConstructor().newInstance();
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
