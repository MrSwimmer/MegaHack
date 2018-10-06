package com.memebattle.megahack.auth.fragment.sign_in;

import android.content.Context;
import android.content.SharedPreferences;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.memebattle.megahack.App;
import com.memebattle.megahack.auth.fragment.core.data.model.SignRequest;
import com.memebattle.megahack.auth.fragment.core.data.model.UserSignIn;
import com.memebattle.megahack.auth.fragment.core.data.model.UserSignUp;
import com.memebattle.megahack.auth.fragment.core.domain.ApiAuthService;

import java.util.ArrayList;

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

            }

            @Override
            public void onSuccess(SignRequest SignRequest) {
                saveSharedPreference("id");
            }
        },new UserSignIn());
    }
    void saveSharedPreference(String id){
        SharedPreferences sharedPreferences = App.app.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(APP_PREFERENCES, id);
        editor.apply();
    }

}
