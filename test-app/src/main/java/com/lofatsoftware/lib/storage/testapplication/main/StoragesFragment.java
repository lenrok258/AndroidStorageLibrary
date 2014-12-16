package com.lofatsoftware.lib.storage.testapplication.main;

import android.widget.TextView;

import com.lofatsoftware.lib.storage.Storage;
import com.lofatsoftware.lib.storage.StorageService;
import com.lofatsoftware.lib.storage.testapplication.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.List;

@EFragment(R.layout.fragment_storages)
public class StoragesFragment extends MainActivityFragment {

    @ViewById(R.id.storages_text)
    TextView textView;

    @Bean
    StorageService storageService;

    @Override
    public String getTitle() {
        return "Discovered storages";
    }

    @AfterViews
    void setupViews() {
        textView.setText(getTextToDisplay());
    }

    /* Private ******************************************* */

    private String getTextToDisplay() {

        List<Storage> availableStorages = storageService.getAvailableStorages();

        StringBuilder resultBuilder = new StringBuilder();
        for (Storage availableStorage : availableStorages) {
            resultBuilder
                    .append(availableStorage)
                    .append("\n");
        }

        return resultBuilder.toString();
    }
}
