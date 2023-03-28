package com.shopping.app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.shopping.app.R;
import com.shopping.app.dao.CartDAO;
import com.shopping.app.model.CartItem;
import com.shopping.app.model.Item;

import java.util.Locale;

public class PagerItemFragment extends Fragment {

    private Item item;

    public PagerItemFragment(Item item) {
        this.item = item;
    }

    public static PagerItemFragment newInstance(Item item) {
        return new PagerItemFragment(item);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pager_fragment_item, container, false);
        ImageView imageView = view.findViewById(R.id.item_image_view_id);
        TextView titleTextView = view.findViewById(R.id.item_title_id);
        TextView priceTextView = view.findViewById(R.id.item_price_txt_id);
        TextView descriptionTextView = view.findViewById(R.id.item_description_txt_id);
        Button addToCartButton = view.findViewById(R.id.add_to_card_btn_id);

        // Load the item data into the views
        imageView.setImageResource(R.drawable.macbook_pro);
        titleTextView.setText(item.getTitle());
        priceTextView.setText(String.format(Locale.getDefault(), "$%.2f", item.getPrice()));
        descriptionTextView.setText(item.getDescription());

        // set button listener
        addToCartButton.setOnClickListener(v -> {
            CartItem cartItem = new CartItem(item, 1);
            new CartDAO().addOrUpdate(cartItem);
            Toast.makeText(view.getContext(),"Added to cart", Toast.LENGTH_SHORT).show();
            int size = new CartDAO().getAll().size();
//            Toast.makeText(view.getContext(), size + "", Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}


