package com.example.citieslistapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.citieslistapp.R;

/**
 * Created by Серёга on 09.07.2017.
 */

public class CityViewHolder extends RecyclerView.ViewHolder {

    public TextView latitude;
    public TextView longitude;
    public TextView summary;
    public TextView evaluation;
    public ImageView image;
    public TextView title;

    public CityViewHolder(View itemView) {
        super(itemView);
        this.latitude = (TextView)itemView.findViewById(R.id.tvLatInf);
        this.longitude =(TextView)itemView.findViewById(R.id.tvLngInf);
        this.summary = (TextView)itemView.findViewById(R.id.tvSummary);
        this.evaluation = (TextView)itemView.findViewById(R.id.tvEvInf);
        this.title = (TextView)itemView.findViewById(R.id.tvTitle);
        this.image = (ImageView)itemView.findViewById(R.id.imageViewCity);
    }
}
