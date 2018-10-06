package com.memebattle.megahack.main.fragment.request.domain;

import com.memebattle.megahack.main.fragment.request.data.RequestApi;
import com.memebattle.megahack.main.fragment.request.data.model.RequestTask;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ApiRequestService {
    RequestApi api;

    public ApiRequestService(RequestApi api) {
        this.api = api;
    }

    public void getTasks(ProfileCallback callback, String opsId) {
        api.sendRequest(opsId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback::onSuccess, callback::onError);
    }

    public interface ProfileCallback {
        void onSuccess(RequestTask requestTask);
        void onError(Throwable e);
    }
}
