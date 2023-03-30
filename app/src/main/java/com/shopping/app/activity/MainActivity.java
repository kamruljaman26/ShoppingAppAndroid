package com.shopping.app.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;
import com.shopping.app.R;
import com.shopping.app.adapder.TabPageAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.R) { // Build.VERSION_CODES.R corresponds to API level 30
//            viewToHide.setVisibility(View.GONE);
        }

        // init tab layout
        TabLayout tabLayout = findViewById(R.id.tabLayoutId);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        // init view pager
        ViewPager viewPager = findViewById(R.id.viewPagerId);

        // Init tab names
        tabLayout.addTab(tabLayout.newTab().setText("Home"));
        tabLayout.addTab(tabLayout.newTab().setText("Items"));
        tabLayout.addTab(tabLayout.newTab().setText("Cart"));

        // init and set tab page adapter
        TabPageAdapter adapter = new TabPageAdapter(this,getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

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