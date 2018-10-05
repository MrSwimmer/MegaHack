package com.memebattle.megahack.auth.fragment.core.data;

import com.memebattle.megahack.auth.fragment.core.data.model.Status;
import com.memebattle.megahack.auth.fragment.core.data.model.User;
import com.memebattle.megahack.main.fragment.profile.data.model.Profile;

import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.POST;
import rx.Observable;

public interface AuthApi {
    @POST("profile/")
    Observable<Status> signIn(@Body User user);

    @POST("profile/")
    Observable<Status> signUp(@Body User user);
}
