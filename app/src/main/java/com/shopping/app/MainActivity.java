package com.shopping.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.shopping.app.adapder.TabPageAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // init tab layout
        TabLayout tabLayout = findViewById(R.id.tabLayoutId);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        // init view pager
        ViewPager viewPager = findViewById(R.id.viewPagerId);

        // init tab names
        tabLayout.addTab(tabLayout.newTab().setText("Home"));
        tabLayout.addTab(tabLayout.newTab().setText("Items"));
        tabLayout.addTab(tabLayout.newTab().setText("Checkout"));

        // init and set tab page adapter
        TabPageAdapter adapter = new TabPageAdapter(this,getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        /*
         * The code you posted is used to sync the TabLayout with the ViewPager so that
         * when a user clicks on a tab, the corresponding page in the ViewPager is displayed.
         * Here's what each part of the code does:
         */
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }


}