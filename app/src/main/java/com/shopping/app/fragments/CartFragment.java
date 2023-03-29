package com.shopping.app.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shopping.app.R;
import com.shopping.app.activity.RegisterActivity;
import com.shopping.app.adapder.CartItemsRecyclerAdapter;
import com.shopping.app.database.CartDatabase;
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
        recyclerView.setAdapter(new CartItemsRecyclerAdapter(new CartDatabase().getAll()));

        // checkout button
        Button checkout = view.findViewById(R.id.checkout_btn_id);
        checkout.setOnClickListener(e ->{
            Intent intent = new Intent(view.getContext(), RegisterActivity.class);
            view.getContext().startActivity(intent);
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        recyclerView.setAdapter(new CartItemsRecyclerAdapter(new CartDatabase().getAll()));
        updateTotal();
    }

    private void updateTotal(){

        // calculate cart total
        AtomicReference<Double> total = new AtomicReference<>((double) 0);
        new CartDatabase().getAll().forEach(c -> {
            total.updateAndGet(v -> new Double((double) (v + c.getItem().getPrice() * c.getQuantity())));
        });

        TextView cartTotal = view.findViewById(R.id.total_price_id);
        cartTotal.setText(String.format("$%.2f", total.get()));
    }
}