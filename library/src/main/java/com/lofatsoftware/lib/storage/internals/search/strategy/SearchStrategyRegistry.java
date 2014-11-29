package com.lofatsoftware.lib.storage.internals.search.strategy;

import android.util.Log;

import com.lofatsoftware.lib.storage.internals.Config;
import com.lofatsoftware.lib.storage.internals.search.strategy.impl.Index;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import static com.lofatsoftware.lib.storage.internals.Config.*;
import static com.lofatsoftware.lib.storage.internals.search.strategy.SearchStrategy.*;

public class SearchStrategyRegistry {

    public static final String KEY_TEMPLATE = "{0}|{1}|{2}";

    /*
        Vendor|Model|APIVersion list(comma separated)
        e.g.:
            "HTC|Desire|14,15,16,17,17,19"
                - means strategy for HTC Desire with Android from version 4.0 to 4.4
            "||19"
                - means strategy for any vendor or model with Android 4.4
     */
    private static final Map<String, SearchStrategy> registry = new HashMap<>();

    static {
        initializeRegistry();
    }

    private static void initializeRegistry() {
        Collection<SearchStrategy> searchStrategies = Index.get();
        for ( SearchStrategy searchStrategy : searchStrategies ) {
            for ( String model : searchStrategy.getModels() ) {
                String key = prepareKey(
                        searchStrategy.getVendor(),
                        model,
                        searchStrategy.getMinSystemApi(),
                        searchStrategy.getMaxSystemApi());
                registry.put( key, searchStrategy );
            }
        }
    }

    private SearchStrategyRegistry() {
        throw new IllegalStateException( "Don't instantiate. Use static methods." );
    }

    public static SearchStrategy getSearchStrategy( String vendor, String model, String systemApi ) {
        return null;
    }

    private static String prepareKey( String vendor, String model, Integer minSystemApi, Integer maxSystemApi ) {
        vendor = vendor.equals( ANY_VENDOR ) ? "" : vendor;
        model = model.equals( ANY_MODEL ) ? "" : model;
        String apiString = prepareApiString( minSystemApi, maxSystemApi );
        return MessageFormat.format( KEY_TEMPLATE, vendor, model, apiString );
    }

    private static String prepareApiString( Integer minSystemApi, Integer maxSystemApi ) {
        minSystemApi = minSystemApi.equals( NO_MIN_API ) ? 1 : minSystemApi;
        maxSystemApi = maxSystemApi.equals( NO_MAX_API ) ? 99 : maxSystemApi;

        StringBuilder result = new StringBuilder();
        for ( int i = minSystemApi; i <= maxSystemApi; i++ ) {
            result.append( i );
            if ( i != maxSystemApi ) {
                result.append( "," );
            }
        }
        return result.toString();
    }


}
