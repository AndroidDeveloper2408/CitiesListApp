package com.example.citieslistapp.base;

import com.example.citieslistapp.model.CityInformation;
import com.example.citieslistapp.model.CityObject;
import com.example.citieslistapp.service.CityViewInterface;

import java.util.List;

import rx.Observer;

/**
 * Created by Серёга on 09.07.2017.
 */

public class CityPresenter extends BasePresenter implements Observer<CityObject> {

    private CityViewInterface mViewInterface;

    public CityPresenter(CityViewInterface cityViewInterface) {
        mViewInterface = cityViewInterface;
    }

    @Override
    public void onCompleted() {
        mViewInterface.onCompleted();
    }

    @Override
    public void onError(Throwable e) {
        mViewInterface.onError(e.getMessage());

    }

    @Override
    public void onNext(CityObject cityObject) {
        mViewInterface.onCityInformations(cityObject);
    }

    public void fetchCities() {
        unSubscribeAll();
        subscribe(mViewInterface.getCities(), CityPresenter.this);
    }
}
