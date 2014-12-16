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

        return search;
    }
}
