package com.memebattle.megahack.main.fragment.profile.data;

import com.memebattle.megahack.auth.fragment.core.data.model.UserSignIn;
import com.memebattle.megahack.main.fragment.profile.data.model.Profile;
import com.memebattle.megahack.main.fragment.profile.data.model.ProfileStatus;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import rx.Observable;

public interface ProfileApi {
    @GET("api/operators/{operatorId}")
    Observable<Profile> getProfile(@Path("operatorId") String id);

    @PUT("api/operatorinprocess")
    Observable<String> setStatus(@Body ProfileStatus profileStatus);
}
