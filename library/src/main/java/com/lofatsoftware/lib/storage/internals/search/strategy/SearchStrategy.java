package com.lofatsoftware.lib.storage.internals.search.strategy;

import com.lofatsoftware.lib.storage.internals.search.input.SearchInput;

import java.util.List;

public interface SearchStrategy {

    List<SearchInput> getSources();

}
