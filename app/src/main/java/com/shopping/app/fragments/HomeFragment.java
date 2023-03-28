package com.shopping.app.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.shopping.app.R;
import com.shopping.app.activity.ItemSliderActivity;
import com.shopping.app.dao.ItemsDAO;
import com.shopping.app.model.Item;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_layout, container, false);

        // get first 2 item
        ItemsDAO itemsDAO = new ItemsDAO();
        itemsDAO.loadDummyData();
        Item item1 = itemsDAO.getById(1);
        Item item2 = itemsDAO.getById(2);

        // item 1
        CardView cardView1 = view.findViewById(R.id.cardView1);
        ImageView item1Img = view.findViewById(R.id.item1_image_id);
        TextView item1Title = view.findViewById(R.id.item1_title_id);
        TextView item1Price = view.findViewById(R.id.item1_price_id);

        item1Img.setImageResource(R.drawable.macbook_pro);
        item1Title.setText(item1.getTitle());
        item1Price.setText("Price: $" + String.format("%.2f", item1.getPrice()));

        cardView1.setOnClickListener(e->{
            Intent intent = new Intent(view.getContext(), ItemSliderActivity.class);
            intent.putExtra("position", item1.getId() - 1);
            view.getContext().startActivity(intent);
        });

        // item 2
        CardView cardView2 = view.findViewById(R.id.cardView2);
        ImageView item2Img = view.findViewById(R.id.item2_image_id);
        TextView item2Title = view.findViewById(R.id.item2_title_id);
        TextView item2Price = view.findViewById(R.id.item2_price_id);

        item2Img.setImageResource(R.drawable.macbook_pro);
        item2Title.setText(item2.getTitle());
        item2Price.setText("Price: $" + String.format("%.2f", item2.getPrice()));

        cardView2.setOnClickListener(e->{
            Intent intent = new Intent(view.getContext(), ItemSliderActivity.class);
            intent.putExtra("position", item2.getId() - 1);
            view.getContext().startActivity(intent);
        });

/*        Intent intent = new Intent(view.getContext(), ItemSliderActivity.class);
        intent.putExtra("position", item.getId() - 1);
        view.getContext().startActivity(intent);*/



        return view;
    }

}