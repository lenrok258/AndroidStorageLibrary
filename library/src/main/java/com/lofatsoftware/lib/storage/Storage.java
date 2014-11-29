package com.lofatsoftware.lib.storage;

public class Storage {

    private String device;
    private String mountPoint;

    public Storage(String device, String mountPoint) {
        this.device = device;
        this.mountPoint = mountPoint;
    }

    @Override
    public String toString() {
        return device + " " + mountPoint;
    }
}
