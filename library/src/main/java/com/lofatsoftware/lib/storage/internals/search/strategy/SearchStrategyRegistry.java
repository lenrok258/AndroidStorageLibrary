package com.lofatsoftware.lib.storage.internals.search.strategy;

import android.util.Log;

import com.lofatsoftware.lib.storage.internals.Config;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import static com.lofatsoftware.lib.storage.internals.Config.*;

public class SearchStrategyRegistry {

    /* Looks awful - TODO: refactor it */
    private static Map<String, Map<String, Map<String, SearchStrategy>>> registry = new HashMap<>();

    static {
        initializeRegistry();
    }

    private static void initializeRegistry() {
        Collection<String> classNames = readClassesFromRelativePath( "impl" );

    }

    private static Collection<String> readClassesFromRelativePath( String relativePath ) {
        URL directoryUrl = SearchStrategyRegistry.class.getResource( relativePath );
        File directory = new File( directoryUrl.getPath() );
        if ( !directory.exists() ) {
            Log.w( LOG_TAG, "Directory " + directory.getPath() + " doesn't exist. Programmer is to blame." );
            return Collections.emptyList();
        }
        File[] files = directory.listFiles( new JavaFilenameFilter() );

        //TODO: Waring in progress
        return null;
    }

    private SearchStrategyRegistry() {
        throw new IllegalStateException( "Don't instantiate. Use static methods." );
    }

    private static class JavaFilenameFilter implements FilenameFilter {

        private final Pattern PATTERN = Pattern.compile( ".*.java" );

        @Override
        public boolean accept( File dir, String filename ) {
            return PATTERN.matcher( filename ).matches();
        }
    }
}
