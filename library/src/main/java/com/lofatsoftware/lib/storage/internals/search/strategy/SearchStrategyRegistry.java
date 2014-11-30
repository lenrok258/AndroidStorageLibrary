package com.lofatsoftware.lib.storage.internals.search.strategy;

import com.lofatsoftware.lib.storage.internals.search.strategy.impl.SearchStrategyImplIndex;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.lofatsoftware.lib.storage.internals.search.strategy.SearchStrategy.*;

public class SearchStrategyRegistry {

    private final String KEY_TEMPLATE = "{0}|{1}";
    private final Map<String, List<SearchStrategy>> registry = new HashMap<>();
    private final SearchStrategyImplIndex searchStrategyImplIndex;

    public SearchStrategyRegistry() {
        initializeRegistry();
        searchStrategyImplIndex = new SearchStrategyImplIndex();
    }

    public SearchStrategy getSearchStrategy(
            String requestedVendor,
            String requestedModel,
            int requestedApiVersion ) {

        SearchStrategy searchStrategy = computeBestStrategy( requestedVendor, requestedModel, requestedApiVersion );
        if ( searchStrategy != null ) {
            return searchStrategy;
        }

        searchStrategy = computeBestStrategy( requestedVendor, ANY_MODEL.get( 0 ), requestedApiVersion );
        if ( searchStrategy != null ) {
            return searchStrategy;
        }

        searchStrategy = computeBestStrategy( ANY_VENDOR, ANY_MODEL.get( 0 ), requestedApiVersion );
        if ( searchStrategy != null ) {
            return searchStrategy;
        }

        throw new IllegalStateException( "No SearchStrategy for this request. Programmer is to blame." );
    }

    /* ****************************************
        Private
     */

    private void initializeRegistry() {
        Collection<SearchStrategy> searchStrategies = searchStrategyImplIndex.get();
        for ( SearchStrategy searchStrategy : searchStrategies ) {
            for ( String model : searchStrategy.getModels() ) {
                String key = prepareKey(
                        searchStrategy.getVendor(),
                        model );
                List<SearchStrategy> searchStrategiesByKey = registry.get( key );
                if ( searchStrategiesByKey == null ) {
                    registry.put( key, new ArrayList<SearchStrategy>() );
                }
                registry.get( key ).add( searchStrategy );
            }
        }
    }

    private String prepareKey( String vendor, String model ) {
        vendor = vendor.equals( ANY_VENDOR ) ? "" : vendor;
        model = model.equals( ANY_MODEL.get( 0 ) ) ? "" : model;
        return MessageFormat.format( KEY_TEMPLATE, vendor, model );
    }

    private SearchStrategy computeBestStrategy( String vendor, String model, int requestedApiVersion ) {
        String key = prepareKey( vendor, model );
        List<SearchStrategy> searchStrategyList = registry.get( key );
        if ( searchStrategyList == null || searchStrategyList.isEmpty() ) {
            return null;
        }

        int bestApiDelta = Integer.MAX_VALUE;
        SearchStrategy bestStrategy = null;
        for ( SearchStrategy searchStrategy : searchStrategyList ) {
            Integer minApi = searchStrategy.getMinSystemApi();
            Integer maxApi = searchStrategy.getMaxSystemApi();
            if ( minApi > requestedApiVersion || maxApi < requestedApiVersion ) {
                continue;
            }
            int currentApiDelta = maxApi - minApi;
            if ( currentApiDelta <= bestApiDelta ) {
                bestStrategy = searchStrategy;
            }
        }
        return bestStrategy;
    }

}
