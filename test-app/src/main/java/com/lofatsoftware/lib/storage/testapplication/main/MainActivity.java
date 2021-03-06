package com.lofatsoftware.lib.storage.testapplication.main;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v13.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.lofatsoftware.lib.storage.testapplication.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.EView;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_test_me_tabs)
public class MainActivity extends Activity implements ActionBar.TabListener {

    @ViewById( R.id.pager )
    ViewPager viewPager;

    SectionsPagerAdapter sectionsPagerAdapter;

    List<MainActivityFragment> fragments = Arrays.asList(
            (MainActivityFragment) new StoragesFragment_(),
            (MainActivityFragment) new ProcMountsFragment_(),
            (MainActivityFragment) new AboutFragment_()
    );

    @AfterViews
    void setupViews() {
        final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode( ActionBar.NAVIGATION_MODE_TABS );

        sectionsPagerAdapter = new SectionsPagerAdapter( getFragmentManager() );

        viewPager.setAdapter( sectionsPagerAdapter );
        viewPager.setOnPageChangeListener( new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected( int position ) {
                actionBar.setSelectedNavigationItem( position );
            }
        } );

        for ( int i = 0; i < sectionsPagerAdapter.getCount(); i++ ) {
            actionBar.addTab(
                    actionBar.newTab()
                            .setText( sectionsPagerAdapter.getPageTitle( i ) )
                            .setTabListener( this ) );
        }
    }

    @Override
    public void onTabSelected( ActionBar.Tab tab, FragmentTransaction fragmentTransaction ) {
        viewPager.setCurrentItem( tab.getPosition() );
    }

    @Override
    public void onTabUnselected( ActionBar.Tab tab, FragmentTransaction fragmentTransaction ) {
    }

    @Override
    public void onTabReselected( ActionBar.Tab tab, FragmentTransaction fragmentTransaction ) {
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter( FragmentManager fragmentManager ) {
            super( fragmentManager );
        }

        @Override
        public Fragment getItem( int position ) {
            return fragments.get( position );
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle( int position ) {
            return fragments.get( position ).getTitle();
        }
    }

}
