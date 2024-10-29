package com.kyriakum.ldil.core.mapping;

import com.kyriakum.ldil.exceptions.InterfaceAlreadyMappedException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public final class MappingService {

    private final Map<Class<?>, Class<?>> interfaceToClassMap = new HashMap<>();

    public <T> void bindClassToClass(@NotNull final Class<T> interfaceType,@NotNull final Class<? extends T> concreteType){

        if(interfaceType == null || concreteType == null){
            throw new RuntimeException("Passed null reference");
        }

        if(Modifier.isAbstract(concreteType.getModifiers())){
            throw new RuntimeException(concreteType.getName() + " cannot be abstract");
        }

        if(interfaceToClassMap.containsKey(interfaceType)){
            throw new InterfaceAlreadyMappedException(interfaceType.getName() + "already mapped!");
        }

        interfaceToClassMap.put(interfaceType,concreteType);

    }

    public @Nullable <T> Class<? extends T> getClassMap(@NotNull Class<T> clasz){
        return (Class<? extends T>) interfaceToClassMap.get(clasz);
    }
}
