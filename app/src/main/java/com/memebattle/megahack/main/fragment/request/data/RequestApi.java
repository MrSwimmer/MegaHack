package com.memebattle.megahack.main.fragment.request.data;

import com.memebattle.megahack.main.fragment.request.data.model.RequestsTask;

import retrofit2.http.Body;
import retrofit2.http.GET;
import rx.Observable;

public interface RequestApi {
    @GET("requests/")
    Observable<RequestsTask> sendRequest(@Body String opsId);
}
