package com.kyriakum.ldil.core.providers;

import com.kyriakum.ldil.annotations.objecttype.Prototype;
import com.kyriakum.ldil.core.providers.strategy.InstanceProviderStrategy;
import com.kyriakum.ldil.core.providers.strategy.StrategyLoader;
import com.kyriakum.ldil.core.providers.strategy.StrategyRegistry;
import com.kyriakum.ldil.exceptions.StrategyInitializationException;
import org.jetbrains.annotations.NotNull;

import java.lang.annotation.Annotation;

public final class DependencyProvider {

    private final StrategyRegistry strategyRegistry;

    public DependencyProvider(){
        strategyRegistry = new StrategyRegistry();
        StrategyLoader.loadStrategies(strategyRegistry);
    }

    public <T> T provideDependency(@NotNull Class<T> clasz) throws StrategyInitializationException {
        if(clasz.getDeclaredAnnotations().length > 0){
            for(Annotation anno : clasz.getDeclaredAnnotations()){
                InstanceProviderStrategy strat = strategyRegistry.getStrategyByAnnotation(anno.annotationType());
                    if(strat != null) return strat.provideInstance(clasz);
            }
        }
        //Default to Prototype
        InstanceProviderStrategy strat = strategyRegistry.getStrategyByAnnotation(Prototype.class);
        T dependency = strat.provideInstance(clasz);

        if(dependency == null){
            throw new StrategyInitializationException("Strategies failed to initialize properly");
        }
        return dependency;
    }
}
