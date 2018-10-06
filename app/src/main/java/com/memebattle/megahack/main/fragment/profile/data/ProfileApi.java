package com.memebattle.megahack.main.fragment.profile.data;

import com.memebattle.megahack.auth.fragment.core.data.model.User;
import com.memebattle.megahack.main.fragment.profile.data.model.Profile;

import retrofit2.http.Body;
import retrofit2.http.PUT;
import rx.Observable;

import retrofit2.http.Field;
import retrofit2.http.POST;

public interface ProfileApi {
    @POST("profile/")
    Observable<Profile> getProfile(@Field("id") String id);

    @PUT("profile/")
    Observable<Profile> setStatus(@Body User user);
}
