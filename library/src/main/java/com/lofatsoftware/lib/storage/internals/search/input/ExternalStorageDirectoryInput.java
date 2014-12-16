package com.lofatsoftware.lib.storage.internals.search.input;

import android.os.Environment;

import com.lofatsoftware.lib.storage.Storage;
import com.lofatsoftware.lib.storage.internals.device.ProcMounts;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class ExternalStorageDirectoryInput implements SearchInput {

    @Override
    public List<Storage> getStorages() {

        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        String mountPoint = externalStorageDirectory.getAbsolutePath();
        String device = new ProcMounts().getDeviceByMountPoint(mountPoint);

        Storage storage = new Storage(device, mountPoint);
        return Collections.singletonList( storage );
    }
}
