package com.memebattle.megahack.auth.fragment.core.domain;

import com.memebattle.megahack.auth.fragment.core.data.AuthApi;
import com.memebattle.megahack.auth.fragment.core.data.model.SignRequest;
import com.memebattle.megahack.auth.fragment.core.data.model.UserSignIn;
import com.memebattle.megahack.auth.fragment.core.data.model.UserSignUp;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ApiAuthService {
    AuthApi api;

    public ApiAuthService(AuthApi api) {
        this.api = api;
    }

    public void signIn(StatusCallback callback, UserSignIn userSignIn) {
        api.signIn(userSignIn)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback::onSuccess, callback::onError);
    }
    public void signUp(StatusCallback callback, UserSignUp userSignUp) {
        api.signUp(userSignUp)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback::onSuccess, callback::onError);
    }

    public interface StatusCallback {
        void onError(Throwable e);

        void onSuccess(SignRequest SignRequest);
    }
}
