package com.memebattle.megahack.main.fragment.profile.domain;

import com.memebattle.megahack.auth.fragment.core.data.model.UserSignIn;
import com.memebattle.megahack.main.fragment.profile.data.ProfileApi;
import com.memebattle.megahack.main.fragment.profile.data.model.Profile;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ApiProfileService {
    ProfileApi api;

    public ApiProfileService(ProfileApi api) {
        this.api = api;
    }

    public void getProfile(String id, ProfileCallback callback) {
        api.getProfile()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback::onSuccess, callback::onError);
    }

    public void setStatus(ProfileCallback callback) {
        api.setStatus(new UserSignIn())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback::onSuccess, callback::onError);
    }

    public interface ProfileCallback {
        void onSuccess(Profile profile);
        void onError(Throwable e);
    }
}
