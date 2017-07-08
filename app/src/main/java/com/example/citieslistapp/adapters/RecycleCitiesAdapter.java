package com.example.citieslistapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.citieslistapp.R;

import java.util.ArrayList;

/**
 * Created by Серёга on 08.07.2017.
 */

public class RecycleCitiesAdapter extends RecyclerView.Adapter<CitiesViewHolder> {

    ArrayList<String> itemList = new ArrayList<>();

    public RecycleCitiesAdapter(ArrayList<String> itemList) {
        this.itemList = itemList;
    }

    @Override
    public CitiesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_cardview, null);
        CitiesViewHolder viewHolder = new CitiesViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CitiesViewHolder holder, int position) {
        holder.cityName.setText(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return (null != itemList ? itemList.size() : 0);
    }
}
