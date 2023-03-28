package com.shopping.app.adapder;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shopping.app.R;
import com.shopping.app.activity.ItemSliderActivity;
import com.shopping.app.model.Item;

import java.util.List;

public class ItemsRecyclerAdapter extends RecyclerView.Adapter<ItemsRecyclerAdapter.ItemsViewHolder> {

    private static final int VIEW_TYPE_1 = 1;
    private static final int VIEW_TYPE_2 = 2;
    private final List<Item> items;

    public ItemsRecyclerAdapter(List<Item> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ItemsViewHolder onCreateViewHolder
            (ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_1) {
            // Inflate layout for view type 1
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_view_layout, parent, false);
            return new ItemsViewHolder(view);
        } else {
            // Inflate layout for view type 2
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.end_item_view_layout, parent, false);
            return new EndOfResultsViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsViewHolder holder, int position) {
        if (position < items.size()) {
            // Get the item at the current position in the list
            Item item = items.get(position);

            // Bind the data to the ViewHolder
            holder.bindData(item);
        } else {
            holder.bindData(null);
        }
    }

    @Override
    public int getItemCount() {
        return items.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position != items.size()) {
            return VIEW_TYPE_1;
        } else {
            return VIEW_TYPE_2;
        }
    }

    public static class ItemsViewHolder extends RecyclerView.ViewHolder {

        private final ImageView itemImage;
        private final TextView itemTitle;
        private final TextView itemPrice;
        private Intent intent;

        public ItemsViewHolder(@NonNull View view) {
            super(view);
            // Define click listener for the ViewHolder's View.
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Item clicked: " + itemTitle.getText(), Toast.LENGTH_SHORT).show();
                    intent = new Intent(view.getContext(), ItemSliderActivity.class);
                    view.getContext().startActivity(intent);
                }
            });
            itemImage = view.findViewById(R.id.item_image_id);
            itemTitle = view.findViewById(R.id.item_title_id);
            itemPrice = view.findViewById(R.id.item_price_id);
        }

        public void bindData(Item item) {
            // Set data for each item view in the RecyclerView
            itemImage.setImageResource(R.drawable.macbook_pro);
            itemTitle.setText(item.getTitle());
            itemPrice.setText("Price: $" + item.getPrice());
            intent.putExtra("position", item.getId());
        }
    }

    // view holder for 'end of line'
    public static class EndOfResultsViewHolder extends ItemsViewHolder {
        public EndOfResultsViewHolder(@NonNull View view) {
            super(view);
            // Define click listener for the ViewHolder's View.
            view.setOnClickListener(v -> Toast.makeText(v.getContext(), "End of result!", Toast.LENGTH_SHORT).show());
        }

        public void bindData(Item item) {
        }
    }
}