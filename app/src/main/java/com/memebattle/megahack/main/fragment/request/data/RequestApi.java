package com.memebattle.megahack.main.fragment.request.data;

import com.memebattle.megahack.main.fragment.request.data.model.RequestTask;

import retrofit2.http.Body;
import retrofit2.http.GET;
import rx.Observable;

public interface RequestApi {
    @GET("requests/")
    Observable<RequestTask> sendRequest(@Body String opsId);
}
