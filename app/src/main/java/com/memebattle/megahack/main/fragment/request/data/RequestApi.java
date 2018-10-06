package com.memebattle.megahack.main.fragment.request.data;

import com.memebattle.megahack.main.fragment.request.data.model.RequestsTask;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface RequestApi {
    @GET("requests/{operatorId}")
    Observable<RequestsTask> sendRequest(@Path("operatorId") String id);
}
