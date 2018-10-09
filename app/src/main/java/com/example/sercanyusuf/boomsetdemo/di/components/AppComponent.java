package com.example.sercanyusuf.boomsetdemo.di.components;


import com.example.sercanyusuf.boomsetdemo.MainActivity;
import com.example.sercanyusuf.boomsetdemo.di.modules.AppModule;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(MainActivity boomsetApp);
    // void inject (MainActivity target);

}