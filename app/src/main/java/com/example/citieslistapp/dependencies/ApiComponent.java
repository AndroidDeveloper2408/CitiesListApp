package com.example.citieslistapp.dependencies;

import com.example.citieslistapp.ui.InfoActivity;

import dagger.Component;

/**
 * Created by Серёга on 09.07.2017.
 */

@CustomScope
@Component(modules = ApiModule.class, dependencies = NetworkComponent.class)
public interface ApiComponent {
    void inject(InfoActivity infoActivity);
}
