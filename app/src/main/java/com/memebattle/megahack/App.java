package com.memebattle.megahack;

import android.app.Application;

import com.memebattle.megahack.auth.fragment.core.data.AuthApi;
import com.memebattle.megahack.auth.fragment.core.domain.ApiAuthService;
import com.memebattle.megahack.main.fragment.profile.data.ProfileApi;
import com.memebattle.megahack.main.fragment.profile.domain.ApiProfileService;
import com.memebattle.megahack.main.fragment.request.data.RequestApi;
import com.memebattle.megahack.main.fragment.request.domain.ApiRequestService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

    public static ApiAuthService apiAuthService;

    public static ApiRequestService apiRequestService;
    public static ApiProfileService apiProfileService;
    Retrofit retrofit;

    public static App app;
  
    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        retrofit = new Retrofit.Builder()
                .baseUrl("http://10.241.103.127:5000/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        AuthApi authApi = retrofit.create(AuthApi.class);
        apiAuthService = new ApiAuthService(authApi);

        ProfileApi profileApi = retrofit.create(ProfileApi.class);
        apiProfileService = new ApiProfileService(profileApi);

        RequestApi requestApi = retrofit.create(RequestApi.class);
        apiRequestService = new ApiRequestService(requestApi);
    }
}
