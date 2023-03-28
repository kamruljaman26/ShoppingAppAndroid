package com.shopping.app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shopping.app.R;
import com.shopping.app.adapder.ItemsAdapter;
import com.shopping.app.dao.ItemsDAO;
import com.shopping.app.model.Item;

import java.util.List;

public class ItemsFragment extends Fragment {

    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.items_layout, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewId);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        ItemsDAO itemsDAO = new ItemsDAO();
        itemsDAO.loadDummyData();

        recyclerView.setAdapter(new ItemsAdapter(itemsDAO.getAll()));

        return view;
    }
}
