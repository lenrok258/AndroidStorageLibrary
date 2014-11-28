package com.lofatsoftware.lib.storage.internals.device;

import android.util.Log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.lofatsoftware.lib.storage.internals.Config.*;

public class ProcMounts {

    private static final String FILE_PATH_MOUNTS = "/proc/mounts";

    private List<ProcMountEntry> procMountEntries = new ArrayList<ProcMountEntry>();

    public ProcMounts() {
        try {
            loadProcMounts();
        } catch ( IOException exception ) {
            Log.w( LOG_TAG, "Unable to read " + FILE_PATH_MOUNTS, exception );
        }
    }

    public List<ProcMountEntry> getProcMountEntries() {
        return procMountEntries;
    }

    public String getDeviceByMountPoint( String mountPoint ) {
        return null;
    }

    /* ****************************************
        Private
     */

    private void loadProcMounts() throws IOException {
        FileReader fileReader = new FileReader( FILE_PATH_MOUNTS );
        BufferedReader bufferedReader = new BufferedReader( fileReader );

        String line = "";
        while ( ( line = bufferedReader.readLine() ) != null ) {
            ProcMountEntry procMountEntry = ProcMountEntry.getInstance( line );
            if ( procMountEntry == null ) {
                continue;
            }
            procMountEntries.add( procMountEntry );
        }
    }

}
