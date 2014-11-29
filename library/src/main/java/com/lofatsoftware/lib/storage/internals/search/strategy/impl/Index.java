package com.lofatsoftware.lib.storage.internals.search.strategy.impl;

import com.lofatsoftware.lib.storage.internals.search.strategy.SearchStrategy;

import java.util.Arrays;
import java.util.Collection;

abstract public class Index {

    private static Collection<SearchStrategy> index = Arrays.asList(
            (SearchStrategy) new Any_any_14_18(),
            (SearchStrategy) new Any_any_any_any()
    );

    private Index() {
        throw new IllegalStateException( "Don't instantiate. Use static methods." );
    }

    public static Collection<SearchStrategy> get() {
        return index;
    }
}
