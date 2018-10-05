package com.memebattle.megahack;

import android.app.Application;

import com.memebattle.megahack.core.di.AppComponent;

public class App extends Application {
    private static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        //component = DaggerAppComponent.builder()
                //.build();
    }

    public static AppComponent getComponent() {
        return component;
    }
}
