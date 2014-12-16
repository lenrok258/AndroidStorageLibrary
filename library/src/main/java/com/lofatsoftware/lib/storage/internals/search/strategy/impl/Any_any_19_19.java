package com.lofatsoftware.lib.storage.internals.search.strategy.impl;

import com.lofatsoftware.lib.storage.internals.search.input.SearchInput;
import com.lofatsoftware.lib.storage.internals.search.strategy.SearchStrategy;

import org.androidannotations.annotations.EBean;

import java.util.List;

@EBean
public class Any_any_19_19 implements SearchStrategy {

    @Override
    public String getVendor() {
        return ANY_VENDOR;
    }

    @Override
    public List<String> getModels() {
        return ANY_MODEL;
    }

    @Override
    public Integer getMinSystemApi() {
        return 19;
    }

    @Override
    public Integer getMaxSystemApi() {
        return 19;
    }

    @Override
    public List<SearchInput> getSearchInputs() {
        return null;
    }
}
