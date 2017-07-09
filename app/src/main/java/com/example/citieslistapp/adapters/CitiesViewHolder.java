package com.example.citieslistapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.citieslistapp.R;
import com.example.citieslistapp.ui.InfoActivity;

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
        if(cityName.getText().toString().equals("No data")){
            Toast.makeText(context, "No data, please tap settings to update", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(context, InfoActivity.class);
            intent.putExtra("intent", cityName.getText().toString());
            context.startActivity(intent);
        }
    }
}
