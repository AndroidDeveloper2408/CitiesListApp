package com.example.citieslistapp.service;

import com.example.citieslistapp.model.CityInformation;
import com.example.citieslistapp.model.CityObject;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Серёга on 09.07.2017.
 */

public interface CityService {

    @GET("/wikipediaSearchJSON/")
    Observable<CityObject> getCities(@Query("q") String q, @Query("maxRows") int maxRows, @Query("username") String username);
}
