package com.lofatsoftware.lib.storage.internals.search.strategy.impl;

import com.lofatsoftware.lib.storage.internals.search.strategy.SearchStrategy;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.Arrays;
import java.util.Collection;

import static org.androidannotations.annotations.EBean.Scope.Singleton;

@EBean
public class SearchStrategyImplIndex {

    @Bean( Any_any_any_any.class )
    SearchStrategy any_any_any_any;

    @Bean( Any_any_14_18.class )
    SearchStrategy any_any_14_18;

    private Collection<SearchStrategy> index = Arrays.asList(
            any_any_any_any,
            any_any_14_18
    );

    public Collection<SearchStrategy> get() {
        return index;
    }
}
