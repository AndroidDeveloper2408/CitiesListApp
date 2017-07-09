package com.example.citieslistapp.dependencies;

import com.example.citieslistapp.service.CityService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Серёга on 09.07.2017.
 */

@Module
public class ApiModule {

    @Provides
    @CustomScope
    CityService provideCityService(Retrofit retrofit){
        return retrofit.create(CityService.class);
    }
}
