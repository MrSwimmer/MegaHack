package com.memebattle.megahack;

import android.app.Application;

import com.memebattle.megahack.core.di.AppComponent;

public class App extends Application {
    private static AppComponent component;

    public static AppComponent getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder()
                .build();
    }
}
