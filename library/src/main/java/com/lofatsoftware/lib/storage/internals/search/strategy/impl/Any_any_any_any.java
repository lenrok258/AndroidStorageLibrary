package com.lofatsoftware.lib.storage.internals.search.strategy.impl;

import com.lofatsoftware.lib.storage.internals.search.input.ExternalStorageDirectoryInput;
import com.lofatsoftware.lib.storage.internals.search.input.SearchInput;
import com.lofatsoftware.lib.storage.internals.search.strategy.SearchStrategy;

import org.androidannotations.annotations.EBean;

import java.util.Arrays;
import java.util.List;

@EBean
public class Any_any_any_any implements SearchStrategy {

    private static final String vendor = SearchStrategy.ANY_VENDOR;
    private static final List<String> model = SearchStrategy.ANY_MODEL;
    private static final int minApiVersion = NO_MIN_API;
    private static final int maxApiVersion = NO_MAX_API;

    private static final List<SearchInput> searchInputs = Arrays.asList(
            (SearchInput) new ExternalStorageDirectoryInput()
    );

    @Override
    public String getVendor() {
        return vendor;
    }

    @Override
    public List<String> getModels() {
        return model;
    }

    @Override
    public Integer getMinSystemApi() {
        return minApiVersion;
    }

    @Override
    public Integer getMaxSystemApi() {
        return maxApiVersion;
    }

    @Override
    public List<SearchInput> getSearchInputs() {
        return searchInputs;
    }
}
