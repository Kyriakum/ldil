package com.kyriakum.ldil.core;

import com.kyriakum.ldil.annotations.Inject;
import com.kyriakum.ldil.core.mapping.MappingService;
import com.kyriakum.ldil.core.providers.DependencyProvider;
import com.kyriakum.ldil.exceptions.StrategyInitializationException;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public final class Injector {

    private final MappingService mappingService;
    private final DependencyProvider dependencyProvider;

    public Injector(@NotNull final DependencyProvider dependencyProvider){
        this.mappingService = new MappingService();
        this.dependencyProvider = dependencyProvider;
    }

    public MappingService getMappingService() {
        return mappingService;
    }

    public <T> T createInstance(@NotNull final Class<T> clasz){
        try {
            T instance = clasz.getDeclaredConstructor().newInstance();
            injectDependencies(instance);
            return instance;
        } catch (InstantiationException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private void injectDependencies(@NotNull final Object instance){
        Class<?> clasz = instance.getClass();

        for(Field field : clasz.getDeclaredFields()){
            if(field.isAnnotationPresent(Inject.class)){
                Class<?> fieldType = field.getType();
                try {

                    //Create class if prototype. if singleton give a singleton obj
                    Class<?> classMap = mappingService.getClassMap(fieldType);

                    if(classMap == null){
                        throw new RuntimeException("Mapping not found");
                    }

                    Object dependency = dependencyProvider.provideDependency(classMap);
                    field.setAccessible(true);
                    field.set(instance, dependency);
                } catch (IllegalAccessException | StrategyInitializationException e) {
                    throw new RuntimeException("Failed to inject dependency into " + field.getName());
                }
            }
        }
    }
}
