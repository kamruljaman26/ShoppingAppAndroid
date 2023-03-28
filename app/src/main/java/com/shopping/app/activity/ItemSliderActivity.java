package com.shopping.app.activity;

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

    private ViewPager viewPager;
    private List<Item> itemList;
    private int selectedPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_slider);

        // Get the selected item and position from the intent
        itemList = new ItemsDAO().getAll();
        selectedPosition = getIntent().getIntExtra("position", 0);

        // Set up the ViewPager with the custom PagerAdapter
        viewPager = findViewById(R.id.viewPager);
        ItemPagerAdapter pagerAdapter = new ItemPagerAdapter(getSupportFragmentManager());
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
                Item item = itemList.get(position);
                Objects.requireNonNull(getSupportActionBar()).setTitle(item.getTitle());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        // Set up the back button
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class ItemPagerAdapter extends FragmentStatePagerAdapter {

        public ItemPagerAdapter(FragmentManager fm) {
            super(fm);
        }

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
