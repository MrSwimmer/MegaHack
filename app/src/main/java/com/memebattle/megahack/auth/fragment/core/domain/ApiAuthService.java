package com.memebattle.megahack.auth.fragment.core.domain;

import com.memebattle.megahack.auth.fragment.core.data.AuthApi;
import com.memebattle.megahack.auth.fragment.core.data.model.Status;
import com.memebattle.megahack.auth.fragment.core.data.model.User;
import com.memebattle.megahack.main.fragment.profile.data.ProfileApi;
import com.memebattle.megahack.main.fragment.profile.data.model.Profile;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ApiAuthService {
    AuthApi api;

    public ApiAuthService(AuthApi api) {
        this.api = api;
    }

    public void sign(StatusCallback callback) {
        api.signIn(new User())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback::onSuccess, callback::onError);
    }

    public interface StatusCallback {
        void onSuccess(Status status);
        void onError(Throwable e);
    }
}
