package com.androidfragments.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidfragments.R;
import com.androidfragments.adapters.MyItemRecyclerViewAdapter;
import com.androidfragments.fragments.model.Item;

import java.util.ArrayList;
import java.util.List;


public class ItemFragment extends Fragment {
    private RecyclerView item_list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
        item_list=(RecyclerView)view.findViewById(R.id.list);
        List<Item> items=new ArrayList<Item>();
        for(int i=0;i<5;i++){
            Item item=new Item();
            item.setItemId(i);
            item.setItemName("item\t"+i);
            item.setItemDescription("description\t"+i);
            items.add(item);
        }
        MyItemRecyclerViewAdapter adapter=new MyItemRecyclerViewAdapter(items);
        item_list.setAdapter(adapter);
        return view;
    }


}
