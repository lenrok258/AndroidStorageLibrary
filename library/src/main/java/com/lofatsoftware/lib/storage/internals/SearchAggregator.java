package com.lofatsoftware.lib.storage.internals;

import com.lofatsoftware.lib.storage.internals.search.strategy.SearchStrategy;

public class SearchAggregator {

    private SearchStrategy searchStrategy;

    public SearchAggregator( SearchStrategy searchStrategy ) {
        this.searchStrategy = searchStrategy;
    }
}
