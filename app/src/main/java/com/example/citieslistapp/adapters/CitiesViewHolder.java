package com.example.citieslistapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.citieslistapp.R;
import com.example.citieslistapp.activities.InfoActivity;

/**
 * Created by Серёга on 08.07.2017.
 */

public class CitiesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView cityName;
    public CardView cardview;

    public CitiesViewHolder(View itemView) {
        super(itemView);
        this.cityName = (TextView)itemView.findViewById(R.id.tvCityName);
        this.cardview = (CardView)itemView.findViewById(R.id.cardView);

        cardview.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Context context = v.getContext();
        Intent intent = new Intent(context, InfoActivity.class);
        intent.putExtra("intent", getAdapterPosition());
        context.startActivity(intent);
    }
}
