package com.kyriakum.ldil.annotations.strategy;

import org.jetbrains.annotations.NotNull;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface StrategySupported {
    @NotNull Class<? extends Annotation> value();
}
