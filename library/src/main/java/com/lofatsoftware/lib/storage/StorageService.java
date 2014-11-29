package com.lofatsoftware.lib.storage;

import android.content.Context;

import com.lofatsoftware.lib.storage.internals.search.SearchService;

import java.util.Arrays;
import java.util.List;

public class StorageService {

    private static StorageService singleInstance;

    private final Context context;
    private final SearchService searchService;

    private StorageService( Context context ) {
        this.context = context;
        searchService = new SearchService();
        if ( singleInstance != null ) {
            throw new IllegalStateException( "Don't use constructor. Use static method getInstance()" );
        }
    }

    public static StorageService getInstance( final Context context ) {
        if ( singleInstance == null ) {
            singleInstance = new StorageService( context );
        }
        return singleInstance;
    }

    public List<Storage> getAvailableStorages() {

        List<Storage> search = searchService.search();

        // validate if storages are valid (ValidationService)

        search = createMockStorages();
        return search;
    }

    private List<Storage> createMockStorages( ) {
        return Arrays.asList(
                new Storage( "/super_drive", "/home/kornel" ),
                new Storage( "/ssd_so_fast_so_big", "/home/lofat" ),
                new Storage( "/sdcard", "/sdcard" )
        );
    }


}
