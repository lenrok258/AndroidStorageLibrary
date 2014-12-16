package com.lofatsoftware.lib.storage.internals.search.strategy.impl;

import com.lofatsoftware.lib.storage.internals.search.strategy.SearchStrategy;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@EBean
public class SearchStrategyImplIndex {

    @Bean( Any_any_any_any.class )
    SearchStrategy any_any_any_any;

    @Bean( Any_any_14_18.class )
    SearchStrategy any_any_14_18;

    @Bean( Any_any_19_19.class )
    SearchStrategy Any_any_19_19;

    private Collection<SearchStrategy> index = new ArrayList<>();

    @AfterInject
    void setup() {
        index.add( any_any_any_any );
        index.add( any_any_14_18 );
        index.add( Any_any_19_19 );
    }

    public Collection<SearchStrategy> get() {
        return index;
    }
}
