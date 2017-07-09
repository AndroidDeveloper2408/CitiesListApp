package com.example.citieslistapp.service;

import com.example.citieslistapp.model.CityObject;

import rx.Observable;

/**
 * Created by Серёга on 09.07.2017.
 */

public interface CityViewInterface {
    void onCompleted();

    void onError(String message);

    void onCityInformations(CityObject cityObject);

    Observable<CityObject> getCities();
}
