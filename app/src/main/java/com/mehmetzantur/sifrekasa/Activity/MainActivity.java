package com.mehmetzantur.sifrekasa.Activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.astuetz.PagerSlidingTabStrip;
import com.mehmetzantur.sifrekasa.R;

/**
 * Created by mehme on 7.02.2016.
 */
public class MainActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnAddNew = (Button)findViewById(R.id.btnAddNew);
        Typeface fontbtnAddNew = Typeface.createFromAsset( getAssets(), "fontawesome-webfont.ttf" );
        btnAddNew.setTypeface(fontbtnAddNew);
        btnAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        Button btnSearch = (Button)findViewById(R.id.btnSearch);
        Typeface fontbtnSearch = Typeface.createFromAsset( getAssets(), "fontawesome-webfont.ttf" );
        btnSearch.setTypeface(fontbtnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button btnAbout = (Button)findViewById(R.id.btnAbout);
        Typeface fontbtnAbout = Typeface.createFromAsset( getAssets(), "fontawesome-webfont.ttf" );
        btnAbout.setTypeface(fontbtnAbout);
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button btnSettings = (Button)findViewById(R.id.btnSettings);
        Typeface fontbtnSettings = Typeface.createFromAsset( getAssets(), "fontawesome-webfont.ttf" );
        btnSettings.setTypeface(fontbtnSettings);
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



        // Get the ViewPager and set it's PagerAdapter so that it can display items
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new SampleFragmentPagerAdapter(getSupportFragmentManager()));

        // Give the PagerSlidingTabStrip the ViewPager
        PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        // Attach the view pager to the tab strip
        tabsStrip.setViewPager(viewPager);



    }




}
