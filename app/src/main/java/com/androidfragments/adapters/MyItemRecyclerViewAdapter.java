package com.androidfragments.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidfragments.R;
import com.androidfragments.fragments.model.Item;


import java.util.List;


public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<Item> mValues;

    public MyItemRecyclerViewAdapter(List<Item> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.txt_name.setText(mValues.get(position).getItemName());
        holder.txt_description.setText(mValues.get(position).getItemDescription());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public  View mView;
        public  TextView txt_name;
        public  TextView txt_description;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            txt_name = (TextView) view.findViewById(R.id.item_name);
            txt_description = (TextView) view.findViewById(R.id.item_description);
        }

    }
}
