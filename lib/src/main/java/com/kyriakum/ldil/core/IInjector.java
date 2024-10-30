package com.kyriakum.ldil.core;

import org.jetbrains.annotations.NotNull;

public interface IInjector {

    <T> T createInstance(@NotNull final Class<T> clasz);

}
