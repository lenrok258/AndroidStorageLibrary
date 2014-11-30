package com.lofatsoftware.lib.storage.internals.device;

import android.os.Build;

public class VendorModelSystem {

    private VendorModelSystem() {
        throw new IllegalStateException("Don't instantiate. Use static methods.");
    }

    public static final String getVendor( ) {
        return Build.MANUFACTURER;
    }

    public static final String getModel() {
        return Build.MODEL;
    }

    public static final int getSystemApi() {
        return Build.VERSION.SDK_INT;
    }
}
