package com.lofatsoftware.lib.storage.testapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.lofatsoftware.lib.storage.StorageService;
import com.lofatsoftware.lib.storage.testapplication.R;


public class TestMe extends Activity {

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_test_me );

        TextView textView = (TextView) findViewById( R.id.test_text_view );
        textView.setText( StorageService.test() );
    }

}
