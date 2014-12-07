package com.lofatsoftware.lib.storage;

import android.content.Context;

import com.lofatsoftware.lib.storage.internals.search.SearchService;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.Arrays;
import java.util.List;

import static org.androidannotations.annotations.EBean.*;

@EBean
public class StorageService {

    @Bean
    SearchService searchService;

    @RootContext
    Context context;

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
