package com.example.citieslistapp.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.citieslistapp.R;

/**
 * Created by Серёга on 08.07.2017.
 */

public class CitiesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView cityName;
    public CardView cardview;

    public CitiesViewHolder(View itemView) {
        super(itemView);
        this.cityName = (TextView)itemView.findViewById(R.id.tvCityName);
    }

    @Override
    public void onClick(View v) {

    }
}
