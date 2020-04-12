package com.bikepnp;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.CustomViewHolder> {
    private Context context;
    private ArrayList<HorizontalScrollItem> items;
    public HorizontalAdapter(Context context, ArrayList<HorizontalScrollItem> items) {
        this.context = context;
        this.items = items;
    }
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.profile_item_layout, parent, false));
    }
    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        //holder.itemTitle.setText(items.get(position).getTitle());
        //holder.itemImage.setImageResource(items.get(position).getImage());
    }
    @Override
    public int getItemCount() {
        return items.size();
    }
    public class CustomViewHolder extends RecyclerView.ViewHolder {
        private ImageView itemImage;
        private TextView itemTitle;
        public CustomViewHolder(View view) {
            super(view);
            itemImage = view.findViewById(R.id.imageView);
            itemTitle = view.findViewById(R.id.textView);
        }
    }
}