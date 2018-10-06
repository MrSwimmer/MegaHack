package com.memebattle.megahack.main.fragment.profile.domain;

import com.memebattle.megahack.auth.fragment.core.data.model.UserSignIn;
import com.memebattle.megahack.main.fragment.profile.data.ProfileApi;
import com.memebattle.megahack.main.fragment.profile.data.model.Profile;
import com.memebattle.megahack.main.fragment.profile.data.model.ProfileStatus;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ApiProfileService {
    ProfileApi api;

    public ApiProfileService(ProfileApi api) {
        this.api = api;
    }

    public void getProfile(String id, ProfileCallback callback) {
        api.getProfile(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback::onSuccess, callback::onError);
    }

    public void setStatus(ProfileStatusCallback callback, ProfileStatus profileStatus) {
        api.setStatus(profileStatus)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback::onSuccess, callback::onError);
    }

    public interface ProfileCallback {
        void onSuccess(Profile profile);
        void onError(Throwable e);
    }
    public interface ProfileStatusCallback {
        void onSuccess(String string);
        void onError(Throwable e);
    }
}
