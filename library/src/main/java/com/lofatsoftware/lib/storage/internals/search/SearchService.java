package com.lofatsoftware.lib.storage.internals.search;

import com.lofatsoftware.lib.storage.Storage;
import com.lofatsoftware.lib.storage.internals.device.VendorModelSystem;
import com.lofatsoftware.lib.storage.internals.search.strategy.SearchStrategy;
import com.lofatsoftware.lib.storage.internals.search.strategy.SearchStrategyRegistry;

import java.util.List;

public class SearchService {

    private SearchStrategyRegistry searchStrategyRegistry = new SearchStrategyRegistry();

    public List<Storage> search() {

        String vendor = VendorModelSystem.getVendor();
        String model = VendorModelSystem.getModel();
        int systemApi = VendorModelSystem.getSystemApi();

        SearchStrategy searchStrategy = searchStrategyRegistry.getSearchStrategy( vendor, model, systemApi );

        // and SearchStrategyRegistry for proper SearchStrategy

        // user Search Strategy to obtain list of Storages

        return null;
    }

}
