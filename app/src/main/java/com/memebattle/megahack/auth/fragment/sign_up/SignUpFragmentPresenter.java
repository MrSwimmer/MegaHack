package com.memebattle.megahack.auth.fragment.sign_up;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.memebattle.megahack.App;
import com.memebattle.megahack.auth.fragment.core.data.model.SignRequest;
import com.memebattle.megahack.auth.fragment.core.data.model.UserSignUp;
import com.memebattle.megahack.auth.fragment.core.domain.ApiAuthService;

import java.util.ArrayList;

import static com.memebattle.megahack.auth.fragment.sign_in.SignInFragmentPresenter.APP_PREFERENCES;

@InjectViewState
public class SignUpFragmentPresenter extends MvpPresenter <SignUpFragmentView> {
    public SignUpFragmentPresenter(){

    }
    public void signUp(String name, String mail, String password, ArrayList<String> type){
        App.apiAuthService.signUp(new ApiAuthService.StatusCallback() {
            @Override
            public void onError(Throwable e) {
                Log.i("TAG", e+"");
            }

            @Override
            public void onSuccess(SignRequest signRequest) {
                App.settingsService.setUserId(signRequest.opsId);
                getViewState().nextActivity();
            }
        },new UserSignUp(mail, name, password, type));
    }
}
