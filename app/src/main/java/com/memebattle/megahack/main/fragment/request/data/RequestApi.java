package com.memebattle.megahack.main.fragment.request.data;

import com.memebattle.megahack.auth.fragment.core.data.model.Status;
import com.memebattle.megahack.main.fragment.request.data.model.Request;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface RequestApi {
    @POST("profile/")
    Observable<Status> sendRequest(@Body Request request);
}
