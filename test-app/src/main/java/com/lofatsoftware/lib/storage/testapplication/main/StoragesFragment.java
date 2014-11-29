package com.lofatsoftware.lib.storage.testapplication.main;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lofatsoftware.lib.storage.Storage;
import com.lofatsoftware.lib.storage.StorageService;
import com.lofatsoftware.lib.storage.testapplication.R;

import java.util.List;

public class StoragesFragment extends MainActivityFragment {

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState ) {

        View rootView = inflater.inflate( R.layout.fragment_storages, container, false );
        TextView textView = (TextView) rootView.findViewById( R.id.storages_text );
        textView.setText( getTextToDisplay() );
        return rootView;
    }

    @Override
    public String getTitle() {
        return "Discovered storages";
    }

    /* Private ******************************************* */

    private String getTextToDisplay() {

        StorageService storageService = StorageService.getInstance( getActivity() );
        List<Storage> availableStorages = storageService.getAvailableStorages();

        StringBuilder resultBuilder = new StringBuilder();
        for ( Storage availableStorage : availableStorages ) {
            resultBuilder
                    .append( availableStorage )
                    .append( "\n" );
        }

        return resultBuilder.toString();
    }
}
