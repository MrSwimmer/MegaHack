package com.memebattle.megahack.auth.fragment.sign_in;

import android.content.Context;
import android.content.SharedPreferences;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.memebattle.megahack.App;

@InjectViewState
public class SignInFragmentPresenter extends MvpPresenter <SignInFragmentView> {
    public static final String APP_PREFERENCES = "settings";
    public static final String USER_ID = "id";

    public SignInFragmentPresenter(){

    }
    void saveSharedPreference(){
        SharedPreferences sharedPreferences = App.getApplication().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(APP_PREFERENCES, "id");
        editor.apply();
    }
}
