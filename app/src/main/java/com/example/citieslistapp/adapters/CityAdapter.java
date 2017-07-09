package com.example.citieslistapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.citieslistapp.R;
import com.example.citieslistapp.model.CityInformation;
import com.example.citieslistapp.model.CityObject;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityViewHolder> {

    private final LayoutInflater mInflater;
    private List<CityInformation> mCityInformationsList;

    public CityAdapter(LayoutInflater inflater){
        mInflater = inflater;
        mCityInformationsList = new ArrayList<>();
    }

    @Override
    public CityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CityViewHolder(mInflater.inflate(R.layout.item_city_information, parent, false));
    }

    @Override
    public void onBindViewHolder(CityViewHolder holder, int position) {
        CityInformation currentCityInformation = mCityInformationsList.get(position);
        holder.title.setText(currentCityInformation.getTitle());
        holder.latitude.setText(String.format("%.1f", currentCityInformation.getLatitude()));
        holder.longitude.setText(String.format("%.1f", currentCityInformation.getLongitude()));
        holder.evaluation.setText(String.valueOf(currentCityInformation.getElevation()) + " meters");
        holder.summary.setText(currentCityInformation.getSummary());
        Picasso.with(holder.itemView.getContext()).load(currentCityInformation.getThumbnailImg())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return mCityInformationsList.size();
    }

    public void addCityInfrormationsResponse(CityObject cityObject) {
        mCityInformationsList.addAll(cityObject.getGeonames());
        notifyDataSetChanged();
    }
}