package com.lofatsoftware.lib.storage.internals.search;

import com.lofatsoftware.lib.storage.Storage;
import com.lofatsoftware.lib.storage.internals.device.VendorModelSystem;

import java.util.List;

public class SearchService {

    public List<Storage> search() {

        String vendor = VendorModelSystem.getVendor();
        String model = VendorModelSystem.getModel();
        String systemApi = VendorModelSystem.getSystemApi();

        // get device vendor + model + android version

        // and SearchStrategyRegistry for proper SearchStrategy

        // user Search Strategy to obtain list of Storages

        return null;
    }

}
