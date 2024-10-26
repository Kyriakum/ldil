package com.kyriakum.ldil.exceptions;

import org.jetbrains.annotations.NotNull;

public class StrategyInitializationException extends Exception {

    public StrategyInitializationException(@NotNull String message){
        super(message);
    }

}
