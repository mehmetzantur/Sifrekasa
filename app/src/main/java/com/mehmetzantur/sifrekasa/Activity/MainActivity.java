package com.mehmetzantur.sifrekasa.Activity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;
import com.mehmetzantur.sifrekasa.R;

import org.w3c.dom.Text;

/**
 * Created by mehme on 7.02.2016.
 */
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final PagerSlidingTabStrip tabStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        final LinearLayout view = (LinearLayout) tabStrip.getChildAt(0);



        Button btnAddNew = (Button) findViewById(R.id.btnAddNew);
        Typeface fontbtnAddNew = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");
        btnAddNew.setTypeface(fontbtnAddNew);
        btnAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        Button btnSearch = (Button) findViewById(R.id.btnSearch);
        Typeface fontbtnSearch = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");
        btnSearch.setTypeface(fontbtnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button btnAbout = (Button) findViewById(R.id.btnAbout);
        Typeface fontbtnAbout = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");
        btnAbout.setTypeface(fontbtnAbout);
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button btnSettings = (Button) findViewById(R.id.btnSettings);
        Typeface fontbtnSettings = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");
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
        setUpTabStrip();

        tabsStrip.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            // This method will be invoked when a new page becomes selected.
            @Override
            public void onPageSelected(int position) {
                //Toast.makeText(MainActivity.this,
                //         "Selected page position: " + position, Toast.LENGTH_SHORT).show();


                for (int i = 0; i < view.getChildCount(); i++) {
                    TextView tv = (TextView) view.getChildAt(i);
                    if (i == position) {
                        tv.setTextColor(Color.RED);
                    } else {
                        tv.setTextColor(Color.LTGRAY);
                    }
                }


            }

            // This method will be invoked when the current page is scrolled
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Code goes here
            }

            // Called when the scroll state changes:
            // SCROLL_STATE_IDLE, SCROLL_STATE_DRAGGING, SCROLL_STATE_SETTLING
            @Override
            public void onPageScrollStateChanged(int state) {
                // Code goes here
            }
        });


    }

    public void setUpTabStrip(){

        Toast.makeText(MainActivity.this,
                 "hop: " , Toast.LENGTH_SHORT).show();

        //your other customizations related to tab strip...blahblah
        // Set first tab selected
        PagerSlidingTabStrip tabStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        LinearLayout view2;

        view2 = ((LinearLayout)tabStrip.getChildAt(0));
        for(int i=0; i < view2.getChildCount(); i++){
            TextView tv = (TextView) view2.getChildAt(i);

            if(i == 0){
                tv.setTextColor(Color.RED);
            } else {
                tv.setTextColor(Color.LTGRAY);
            }
        }

    }

}
