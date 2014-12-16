package com.lofatsoftware.lib.storage.internals.search;

import com.lofatsoftware.lib.storage.Storage;
import com.lofatsoftware.lib.storage.internals.device.VendorModelSystem;
import com.lofatsoftware.lib.storage.internals.search.input.SearchInput;
import com.lofatsoftware.lib.storage.internals.search.strategy.SearchStrategy;
import com.lofatsoftware.lib.storage.internals.search.strategy.SearchStrategyRegistry;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.ArrayList;
import java.util.List;

@EBean
public class SearchService {

    @Bean
    SearchStrategyRegistry searchStrategyRegistry;

    public List<Storage> search() {

        SearchStrategy searchStrategy = searchStrategyRegistry.getSearchStrategy();

        List<Storage> result = new ArrayList<>();
        for (SearchInput searchInput : searchStrategy.getSearchInputs()) {
            List<Storage> storages = searchInput.getStorages();
            result.addAll(storages);
        }

        return result;
    }

}
