package com.kyriakum.ldil.exceptions;

import org.jetbrains.annotations.NotNull;

public class StrategyInitializationException extends Exception {

    public StrategyInitializationException(@NotNull final String message){
        super(message);
    }

}
