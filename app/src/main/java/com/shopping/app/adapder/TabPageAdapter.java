package com.shopping.app.adapder;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.shopping.app.fragments.HomeFragment;
import com.shopping.app.fragments.ItemsFragment;
import com.shopping.app.fragments.CheckoutFragment;

public class TabPageAdapter extends FragmentPagerAdapter {
    private Context context;
    private final int totalTabs;

    public TabPageAdapter(Context c, FragmentManager fm, int totalTabs) {
        super(fm);
        context = c;
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new ItemsFragment();
            case 2:
                return new CheckoutFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}



