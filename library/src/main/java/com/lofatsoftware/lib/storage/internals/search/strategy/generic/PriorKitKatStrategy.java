package com.lofatsoftware.lib.storage.internals.search.strategy.generic;

import com.lofatsoftware.lib.storage.internals.search.input.ExternalStorageDirectoryInput;
import com.lofatsoftware.lib.storage.internals.search.input.SearchInput;
import com.lofatsoftware.lib.storage.internals.search.strategy.SearchStrategy;

import java.util.ArrayList;
import java.util.List;

public class PriorKitKatStrategy implements SearchStrategy {

    @Override
    public List<SearchInput> getSources() {
        ArrayList<SearchInput> searchSources = new ArrayList<SearchInput>();

        searchSources.add( new ExternalStorageDirectoryInput() );

        return searchSources;
    }
}
