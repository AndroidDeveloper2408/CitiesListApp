package com.example.citieslistapp.application;

import android.app.Application;

import com.example.citieslistapp.dependencies.ApiComponent;
import com.example.citieslistapp.dependencies.DaggerApiComponent;
import com.example.citieslistapp.dependencies.DaggerNetworkComponent;
import com.example.citieslistapp.dependencies.NetworkComponent;
import com.example.citieslistapp.dependencies.NetworkModule;
import com.example.citieslistapp.network.Constants;

/**
 * Created by Серёга on 09.07.2017.
 */

public class CityApplication extends Application {

    private ApiComponent mApiComponent;

    @Override
    public void onCreate() {
        resolveDependency();
        super.onCreate();
    }

    private void resolveDependency() {
        mApiComponent = DaggerApiComponent.builder().networkComponent(getNetworkComponent())
                .build();

    }

    private NetworkComponent getNetworkComponent() {
        return DaggerNetworkComponent.builder()
                .networkModule(new NetworkModule(Constants.BASE_URL))
                .build();
    }

    public ApiComponent getApiComponent() {
        return mApiComponent;
    }
}
