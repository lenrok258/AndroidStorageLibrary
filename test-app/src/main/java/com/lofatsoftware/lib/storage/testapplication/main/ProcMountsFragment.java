package com.lofatsoftware.lib.storage.testapplication.main;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.lofatsoftware.lib.storage.internals.device.ProcMountEntry;
import com.lofatsoftware.lib.storage.internals.device.ProcMounts;
import com.lofatsoftware.lib.storage.testapplication.R;

import java.util.List;

public class ProcMountsFragment extends MainActivityFragment {

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState ) {

        View rootView = inflater.inflate( R.layout.fragment_proc_mounts, container, false );
        TextView textView = (TextView) rootView.findViewById( R.id.procmounts_text );
        textView.setText( getTextToDisplay() );
        return rootView;
    }

    @Override
    public String getTitle() {
        return "/proc/mounts";
    }

    /* Private ******************************************* */

    private String getTextToDisplay() {
        ProcMounts procMounts = new ProcMounts();
        List<ProcMountEntry> procMountEntries = procMounts.getProcMountEntries();
        StringBuilder resultBuilder = new StringBuilder();
        for ( ProcMountEntry procMountEntry : procMountEntries ) {
            resultBuilder
                    .append( procMountEntry )
                    .append( "\n" );
        }
        return resultBuilder.toString();
    }
}
