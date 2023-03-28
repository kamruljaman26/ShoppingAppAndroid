package com.shopping.app.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.shopping.app.R;
import com.shopping.app.dao.ItemsDAO;
import com.shopping.app.fragments.PagerItemFragment;
import com.shopping.app.model.Item;

import java.util.List;
import java.util.Objects;

public class ItemSliderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_slider);

        // Set up the back button
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Back");

        // Get the selected item and position from the intent
        ItemsDAO itemsDAO = new ItemsDAO();
        itemsDAO.loadDummyData();
        List<Item> itemList = itemsDAO.getAll();
        int selectedPosition = getIntent().getIntExtra("position", 0);

//        Toast.makeText(getApplicationContext(), "Item clicked: " + itemList.get(selectedPosition).getTitle(), Toast.LENGTH_SHORT).show();

        // Set up the ViewPager with the custom PagerAdapter
        ViewPager viewPager = findViewById(R.id.viewPager);
        ItemPagerAdapter pagerAdapter = new ItemPagerAdapter(getSupportFragmentManager(), itemList);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(selectedPosition);

        // Add a PageChangeListener to the ViewPager for swipe left and right functionality
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == itemList.size() - 1 && positionOffset == 0 && positionOffsetPixels == 0) {
                    Toast.makeText(ItemSliderActivity.this, "End of results", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static class ItemPagerAdapter extends FragmentStatePagerAdapter {
        private final List<Item> itemList;

        public ItemPagerAdapter(FragmentManager fm, List<Item> itemList) {
            super(fm);
            this.itemList = itemList;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            Item item = itemList.get(position);
            return PagerItemFragment.newInstance(item);
        }

        @Override
        public int getCount() {
            return itemList.size();
        }
    }
}
