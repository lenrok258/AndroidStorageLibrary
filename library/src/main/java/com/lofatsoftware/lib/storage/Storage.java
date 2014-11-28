package com.lofatsoftware.lib.storage;

public class Storage {

    private String path;
    private String device;

    public Storage(String mountPoint, String device) {
        this.path = mountPoint;
        this.device = device;
    }
}
