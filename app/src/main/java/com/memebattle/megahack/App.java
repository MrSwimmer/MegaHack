package com.memebattle.megahack;

import android.app.Application;

import com.memebattle.megahack.core.di.AppComponent;

public class App extends Application {
    private static App component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = this;
        //component = DaggerAppComponent.builder()
                //.build();
    }

    public static App getApplication() {
        return component;
    }


}
