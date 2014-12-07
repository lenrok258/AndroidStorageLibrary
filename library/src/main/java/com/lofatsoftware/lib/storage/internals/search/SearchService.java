package com.lofatsoftware.lib.storage.internals.search;

import com.lofatsoftware.lib.storage.Storage;
import com.lofatsoftware.lib.storage.internals.device.VendorModelSystem;
import com.lofatsoftware.lib.storage.internals.search.strategy.SearchStrategy;
import com.lofatsoftware.lib.storage.internals.search.strategy.SearchStrategyRegistry;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.List;

@EBean
public class SearchService {

    @Bean
    SearchStrategyRegistry searchStrategyRegistry;

    @Bean
    VendorModelSystem vendorModelSystem;

    public List<Storage> search() {

        SearchStrategy searchStrategy = searchStrategyRegistry.getSearchStrategy( );

        // user Search Strategy to obtain list of Storages

        return null;
    }

}
