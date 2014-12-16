package com.lofatsoftware.lib.storage.internals.search.strategy.impl;

import android.os.Build;

import com.lofatsoftware.lib.storage.internals.search.SearchService;
import com.lofatsoftware.lib.storage.internals.search.input.ExternalStorageDirectoryInput;
import com.lofatsoftware.lib.storage.internals.search.input.SearchInput;
import com.lofatsoftware.lib.storage.internals.search.strategy.SearchStrategy;

import org.androidannotations.annotations.EBean;

import java.util.Arrays;
import java.util.List;

@EBean
public class Any_any_14_18 implements SearchStrategy {

    private static final String vendor = SearchStrategy.ANY_VENDOR;
    private static final List<String> model = SearchStrategy.ANY_MODEL;
    private static final int minApiVersion = Build.VERSION_CODES.ICE_CREAM_SANDWICH; // API:14, Android 4.0;
    private static final int maxApiVersion = Build.VERSION_CODES.JELLY_BEAN_MR2; // API:18, Android: 4.3

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
