package com.mehmetzantur.sifrekasa.Activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.mehmetzantur.sifrekasa.Model.DBHelper;
import com.mehmetzantur.sifrekasa.R;

import android.view.ViewGroup.LayoutParams;

import org.w3c.dom.Text;

/**
 * Created by mehme on 7.02.2016.
 */
public class MainActivity extends AppCompatActivity {

    SlidingMenu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /*  SLIDING MENU */
        menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.RIGHT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
        menu.setShadowWidth(5);
        menu.setFadeDegree(0.0f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        double NewWidth = width * .5;
        menu.setBehindWidth((int) NewWidth);
        menu.setMenu(R.layout.activity_search);


        final PagerSlidingTabStrip tabStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        final LinearLayout view = (LinearLayout) tabStrip.getChildAt(0);


        Button btnAddNew = (Button) findViewById(R.id.btnAddNew);
        Typeface fontbtnAddNew = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");
        btnAddNew.setTypeface(fontbtnAddNew);
        btnAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AddActivity.class));
            }
        });


        Button btnSearch = (Button) findViewById(R.id.btnSearch);
        Typeface fontbtnSearch = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");
        btnSearch.setTypeface(fontbtnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu.toggle();
                EditText txtSearch = (EditText) findViewById(R.id.txtSearch);
                txtSearch.setFocusableInTouchMode(true);
                txtSearch.requestFocus();
                //TODO Tıklandığında klavyeyi aç
                InputMethodManager inputMethodManager=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
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


    public void setUpTabStrip() {

        Toast.makeText(MainActivity.this,
                "Hoşgeldiniz... ", Toast.LENGTH_SHORT).show();

        //your other customizations related to tab strip...blahblah
        // Set first tab selected
        PagerSlidingTabStrip tabStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        LinearLayout view2;

        view2 = ((LinearLayout) tabStrip.getChildAt(0));
        for (int i = 0; i < view2.getChildCount(); i++) {
            TextView tv = (TextView) view2.getChildAt(i);

            if (i == 0) {
                tv.setTextColor(Color.RED);
            } else {
                tv.setTextColor(Color.LTGRAY);
            }
        }

    }



}














