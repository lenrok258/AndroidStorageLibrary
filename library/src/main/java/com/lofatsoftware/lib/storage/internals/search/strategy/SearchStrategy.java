package com.lofatsoftware.lib.storage.internals.search.strategy;

import com.lofatsoftware.lib.storage.internals.search.input.SearchInput;

import java.util.List;

public interface SearchStrategy {

    String ANY = null;

    /**
     * Returns vendor for which this SearchStrategy should be used.
     * If SearchStrategy should be used for any vendor, SearchStrategy.ANY should be returned.
     * @return
     */
    String getVendor();

    /**
     * Returns models list names for which this SearchStrategy should be used.
     * If SearchStrategy should be used for any model, SearchStrategy.ANY should be returned.
     * @return
     */
    List<String> getModels();

    /**
     * Returns min Android API version for which this SearchStrategy should be used.
     * If SearchStrategy is should be used for any Android API version, SearchStrategy.ANY should be returned.
     * @return
     */
    Integer getMinSystemApi();

    /**
     * Returns max Android API version for which this SearchStrategy should be used.
     * If SearchStrategy is should be used for any Android API version, SearchStrategy.ANY should be returned.
     * @return
     */
    Integer getMaxSystemApi();

    /**
     * Should return list of SearchInput used for this SearchStrategy
     * @return
     */
    List<SearchInput> getSources();

}
