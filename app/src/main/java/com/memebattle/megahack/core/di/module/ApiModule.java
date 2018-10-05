package com.memebattle.megahack.core.di.module;

import com.memebattle.megahack.main.fragment.profile.data.ProfileApi;
import com.memebattle.megahack.main.fragment.profile.domain.ApiProfileService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {

    @Provides
    @Singleton
    public Retrofit providesService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://172.16.21.151:8090/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;
    }

    @Provides
    @Singleton
    public ApiProfileService profileService(Retrofit retrofit) {
        ProfileApi api = retrofit.create(ProfileApi.class);
        return new ApiProfileService(api);
    }
}
