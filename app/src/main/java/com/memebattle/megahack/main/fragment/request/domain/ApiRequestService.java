package com.memebattle.megahack.main.fragment.request.domain;

import com.memebattle.megahack.auth.fragment.core.data.model.Status;
import com.memebattle.megahack.auth.fragment.core.data.model.User;
import com.memebattle.megahack.main.fragment.profile.data.ProfileApi;
import com.memebattle.megahack.main.fragment.profile.data.model.Profile;
import com.memebattle.megahack.main.fragment.request.data.RequestApi;
import com.memebattle.megahack.main.fragment.request.data.model.Request;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ApiRequestService {
    RequestApi api;

    public ApiRequestService(RequestApi api) {
        this.api = api;
    }

    public void getProfile(ProfileCallback callback) {
        api.sendRequest(new Request())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback::onSuccess, callback::onError);
    }

    public interface ProfileCallback {
        void onSuccess(Status status);
        void onError(Throwable e);
    }
}
