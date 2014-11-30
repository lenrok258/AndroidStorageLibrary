package com.lofatsoftware.lib.storage.internals.search.strategy;

import com.lofatsoftware.lib.storage.internals.search.input.SearchInput;

import java.util.Collections;
import java.util.List;

public interface SearchStrategy {

    String ANY_VENDOR = "";
    List<String> ANY_MODEL = Collections.singletonList( "" );
    Integer NO_MIN_API = 0;
    Integer NO_MAX_API = Integer.MAX_VALUE;

    /**
     * Returns vendor for which this SearchStrategy should be used.
     * If SearchStrategy should be used for any vendor, SearchStrategy.ANY_VENDOR should be returned.
     * @return
     */
    String getVendor();

    /**
     * Returns models list names for which this SearchStrategy should be used.
     * If SearchStrategy should be used for any model, SearchStrategy.ANY_MODEL should be returned.
     * @return
     */
    List<String> getModels();

    /**
     * Returns min Android API version for which this SearchStrategy should be used.
     * If SearchStrategy is should be used for any Android API version, SearchStrategy.NO_MIN_API should be returned.
     * @return
     */
    Integer getMinSystemApi();

    /**
     * Returns max Android API version for which this SearchStrategy should be used.
     * If SearchStrategy is should be used for any Android API version, SearchStrategy.NO_MAX_API should be returned.
     * @return
     */
    Integer getMaxSystemApi();

    /**
     * Should return list of SearchInput used for this SearchStrategy
     * @return
     */
    List<SearchInput> getSearchInputs();

}
