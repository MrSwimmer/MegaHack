package com.memebattle.megahack;

import android.app.Application;

import com.memebattle.megahack.auth.fragment.core.data.AuthApi;
import com.memebattle.megahack.auth.fragment.core.domain.ApiAuthService;
import com.memebattle.megahack.main.fragment.profile.data.ProfileApi;
import com.memebattle.megahack.main.fragment.profile.domain.ApiProfileService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {
    ApiProfileService apiProfileService;
    ApiAuthService apiAuthService;
    Retrofit retrofit;

    public static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        retrofit = new Retrofit.Builder()
                .baseUrl("http://миша/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ProfileApi profileApi = retrofit.create(ProfileApi.class);
        apiProfileService = new ApiProfileService(profileApi);
        AuthApi authApi = retrofit.create(AuthApi.class);
        apiAuthService = new ApiAuthService(authApi);
    }


}
