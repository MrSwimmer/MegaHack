package com.memebattle.megahack.main.fragment.profile.presentation;

import android.content.Context;
import android.content.Intent;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.memebattle.megahack.App;
import com.memebattle.megahack.R;
import com.memebattle.megahack.auth.activity.AuthActivity;
import com.memebattle.megahack.main.activity.MainActivity;
import com.memebattle.megahack.main.fragment.profile.data.model.Profile;
import com.memebattle.megahack.main.fragment.profile.domain.ApiProfileService;

@InjectViewState
public class ProfileFragmentPresenter extends MvpPresenter <ProfileFragmentView> {
    public ProfileFragmentPresenter() {

    }

    void getProfile() {
        String id = App.settingsService.getUserId();
        App.apiProfileService.getProfile(id, new ApiProfileService.ProfileCallback() {
            @Override
            public void onSuccess(Profile profile) {
                getViewState().setProfile(profile);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
}
