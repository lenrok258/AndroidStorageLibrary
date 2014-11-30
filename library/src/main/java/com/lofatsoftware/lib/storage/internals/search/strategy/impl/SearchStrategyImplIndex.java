package com.lofatsoftware.lib.storage.internals.search.strategy.impl;

import com.lofatsoftware.lib.storage.internals.search.strategy.SearchStrategy;

import java.util.Arrays;
import java.util.Collection;

public class SearchStrategyImplIndex {

    private Collection<SearchStrategy> index = Arrays.asList(
            (SearchStrategy) new Any_any_14_18(),
            (SearchStrategy) new Any_any_any_any()
    );

    public Collection<SearchStrategy> get() {
        return index;
    }
}
