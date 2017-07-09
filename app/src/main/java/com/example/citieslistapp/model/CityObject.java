package com.example.citieslistapp.model;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by Серёга on 09.07.2017.
 */

public class CityObject {


    public List<CityInformation> getGeonames() {
        return geonames;
    }

    public void setGeonames(List<CityInformation> geonames) {
        this.geonames = geonames;
    }

    @Expose
    private List<CityInformation> geonames;
}
