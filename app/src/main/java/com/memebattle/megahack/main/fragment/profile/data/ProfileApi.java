package com.memebattle.megahack.main.fragment.profile.data;

import com.memebattle.megahack.main.fragment.profile.data.model.Profile;

import rx.Observable;

import retrofit2.http.Field;
import retrofit2.http.POST;

public interface ProfileApi {
    @POST("profile/")
    Observable<Profile> getProfile(@Field("id") String id);
}
