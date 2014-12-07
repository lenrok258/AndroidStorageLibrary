package com.lofatsoftware.lib.storage.internals.device;

import android.os.Build;

import org.androidannotations.annotations.EBean;

import static org.androidannotations.annotations.EBean.Scope.Singleton;

@EBean
public class VendorModelSystem {

    public String getVendor( ) {
        return Build.MANUFACTURER;
    }

    public String getModel() {
        return Build.MODEL;
    }

    public int getSystemApi() {
        return Build.VERSION.SDK_INT;
    }
}
