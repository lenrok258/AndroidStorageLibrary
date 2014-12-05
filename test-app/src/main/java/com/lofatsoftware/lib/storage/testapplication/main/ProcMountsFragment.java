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

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.List;

@EFragment( R.layout.fragment_proc_mounts )
public class ProcMountsFragment extends MainActivityFragment {

    @ViewById( R.id.procmounts_text )
    TextView textView;

    @Override
    public String getTitle() {
        return "/proc/mounts";
    }

    @AfterViews
    void setupViews() {
        textView.setText( getTextToDisplay() );
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
