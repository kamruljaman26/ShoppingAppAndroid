package com.shopping.app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shopping.app.R;
import com.shopping.app.adapder.CartItemsRecyclerAdapter;
import com.shopping.app.adapder.ItemsRecyclerAdapter;
import com.shopping.app.dao.CartDAO;
import com.shopping.app.dao.ItemsDAO;

import java.util.concurrent.atomic.AtomicReference;

public class CartFragment extends Fragment {

    private RecyclerView recyclerView;
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.cart_layout, container, false);

        // calculate cart total
        updateTotal();

        // recycler view
        recyclerView = view.findViewById(R.id.cart_item_recyclyer_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new CartItemsRecyclerAdapter(new CartDAO().getAll()));

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        recyclerView.setAdapter(new CartItemsRecyclerAdapter(new CartDAO().getAll()));
        updateTotal();
    }

    private void updateTotal(){
        // calculate cart total
        AtomicReference<Double> total = new AtomicReference<>((double) 0);
        new CartDAO().getAll().forEach(c -> {
            total.updateAndGet(v -> new Double((double) (v + c.getItem().getPrice() * c.getQuantity())));
        });

        TextView cartTotal = view.findViewById(R.id.total_price_id);
        cartTotal.setText(String.format("$%.2f", total.get()));
    }
}