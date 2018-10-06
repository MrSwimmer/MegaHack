package com.memebattle.megahack.main.fragment.profile.data;

import com.memebattle.megahack.auth.fragment.core.data.model.UserSignIn;
import com.memebattle.megahack.main.fragment.profile.data.model.Profile;

import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import rx.Observable;

import retrofit2.http.Field;
import retrofit2.http.POST;

public interface ProfileApi {
    @GET("profile/")
    Observable<Profile> getProfile();

    @PUT("profile/")
    Observable<Profile> setStatus(@Body UserSignIn userSignIn);
}
