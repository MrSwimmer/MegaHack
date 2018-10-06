package com.memebattle.megahack.auth.fragment.sign_in;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.memebattle.megahack.App;
import com.memebattle.megahack.auth.fragment.core.data.model.SignRequest;
import com.memebattle.megahack.auth.fragment.core.data.model.UserSignIn;
import com.memebattle.megahack.auth.fragment.core.domain.ApiAuthService;


@InjectViewState
public class SignInFragmentPresenter extends MvpPresenter <SignInFragmentView> {
    public static final String APP_PREFERENCES = "settings";
    public static final String USER_ID = "id";

    public SignInFragmentPresenter(){

    }
    public void signIn(String mail, String password){
        App.apiAuthService.signIn(new ApiAuthService.StatusCallback() {
            @Override
            public void onError(Throwable e) {
                Log.i("TAG",e+"");
            }

            @Override
            public void onSuccess(SignRequest signRequest) {
                App.settingsService.setUserId(signRequest.opsId);
                getViewState().nextActivity();
            }
        },new UserSignIn(mail,password));
    }
}
