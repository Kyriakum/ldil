package com.kyriakum.ldil.exceptions;

import org.jetbrains.annotations.NotNull;

public final class InterfaceAlreadyMappedException extends RuntimeException {

    public InterfaceAlreadyMappedException(@NotNull final String message){
        super(message);
    }

}
