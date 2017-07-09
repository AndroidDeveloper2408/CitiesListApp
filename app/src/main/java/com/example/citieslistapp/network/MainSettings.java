package com.example.citieslistapp.network;

import android.content.Context;
import android.util.Log;

import com.example.citieslistapp.database.DB;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Серёга on 07.07.2017.
 */

public class MainSettings {

    DB db;

    public void parseJson(String result, Context context) {
        try {
            db = new DB(context);
            db.open();

            JSONObject reader = new JSONObject(result);
            for (int j = 0; j < reader.length(); j++) {
                //Log.d(TAG, "Country " + j + ": " + reader.names().getString(j));
                db.addRecToCountries(reader.names().getString(j));
                JSONArray cities = reader.getJSONArray(reader.names().getString(j));
                for(int i=0; i < cities.length();i++){
                    //Log.d(TAG, "Country_Id: " + j + " Country_Name: " +
                    //reader.names().getString(j) + "  City " + i +  " Name: " + cities.get(i).toString());
                    //db.addRecToCities(j, reader.names().getString(j));
                }
            }
        } catch (JSONException e) {
            Log.e("JSONException Data", result);
            e.printStackTrace();
        }
    }

    public ArrayList<String> findCitiesbyCountry(String result, String country){
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            JSONObject reader = new JSONObject(result);
            JSONArray cities = reader.getJSONArray(country);
            for(int i=0; i < cities.length();i++){
                arrayList.add(cities.get(i).toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
