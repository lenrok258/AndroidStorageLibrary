package com.lofatsoftware.lib.storage.testapplication.main;

import android.widget.TextView;

import com.lofatsoftware.lib.storage.internals.device.ProcMountEntry;
import com.lofatsoftware.lib.storage.internals.device.ProcMounts;
import com.lofatsoftware.lib.storage.testapplication.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.List;

@EFragment(R.layout.fragment_proc_mounts)
public class ProcMountsFragment extends MainActivityFragment {

    private static final String SEPARATOR = " | ";

    @Override
    public String getTitle() {
        return "/proc/mounts";
    }

    @ViewById(R.id.proc_mounts_text)
    TextView textView;

    @AfterViews
    void setupViews() {
        String textToDisplay = getTextToDisplay();
        textView.setText(textToDisplay);
    }

    /* Private ******************************************* */

    private String getTextToDisplay() {
        ProcMounts procMounts = new ProcMounts();
        List<ProcMountEntry> procMountEntries = procMounts.getProcMountEntries();
        StringBuilder textToDisplay = new StringBuilder();
        for (ProcMountEntry entry : procMountEntries) {
           textToDisplay
                   .append(entry.getDevice() + SEPARATOR)
                   .append(entry.getMountPoint() + SEPARATOR)
                   .append(entry.getFileSystemType() + SEPARATOR)
                   .append("\n\n");
        }
        return textToDisplay.toString();
    }
}
