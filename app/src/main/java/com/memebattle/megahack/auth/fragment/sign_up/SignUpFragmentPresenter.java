package com.memebattle.megahack.auth.fragment.sign_up;

import android.content.Context;
import android.content.SharedPreferences;

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
    public void signUp(String name, String mail, String password, ArrayList<Integer> type){
        App.apiAuthService.signUp(new ApiAuthService.StatusCallback() {
            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onSuccess(SignRequest SignRequest) {
                saveSharedPreference("id");
            }
        },new UserSignUp());
    }
    void saveSharedPreference(String id){
        SharedPreferences sharedPreferences = App.app.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(APP_PREFERENCES, id);
        editor.apply();
    }
}
