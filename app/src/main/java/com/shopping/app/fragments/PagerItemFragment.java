package com.shopping.app.fragments;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.shopping.app.R;
import com.shopping.app.model.Item;

import java.util.Locale;

public class PagerItemFragment extends Fragment {

    private Item item;

    public static PagerItemFragment newInstance(Item item) {
        PagerItemFragment fragment = new PagerItemFragment();
        Bundle args = new Bundle();
        args.putParcelable("item", (Parcelable) item);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            item = getArguments().getParcelable("item");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pager_fragment_item, container, false);
//        ImageView imageView = view.findViewById(R.id.imageView);
//        TextView titleTextView = view.findViewById(R.id.titleTextView);
//        TextView priceTextView = view.findViewById(R.id.priceTextView);
//        TextView descriptionTextView = view.findViewById(R.id.descriptionTextView);

        // Load the item data into the views
//        imageView.setImageResource(R.drawable.macbook_pro);
//        titleTextView.setText(item.getTitle());
//        priceTextView.setText(String.format(Locale.getDefault(), "$%.2f", item.getPrice()));
//        descriptionTextView.setText(item.getDescription());

        return view;
    }
}


