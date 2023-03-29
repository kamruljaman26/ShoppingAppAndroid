package com.shopping.app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shopping.app.R;
import com.shopping.app.adapder.ItemsRecyclerAdapter;
import com.shopping.app.database.ItemsDatabase;

public class ItemsFragment extends Fragment {

    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.items_layout, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewId);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        ItemsDatabase itemsDatabase = new ItemsDatabase();
        itemsDatabase.loadDummyData();

        recyclerView.setAdapter(new ItemsRecyclerAdapter(itemsDatabase.getAll()));

        return view;
    }
}
