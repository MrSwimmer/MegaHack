package com.memebattle.megahack.core;

import android.content.Context;
import android.content.SharedPreferences;

public class SettingsService {
    SharedPreferences sharedPreferences;

    public static final String APP_PREFERENCES = "settings";
    public static final String ERROR = "error";
    public static final String USER_ID = "id";

    public SettingsService(Context context) {
        sharedPreferences = context.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
    }

    public String getUserId() {
        return sharedPreferences.getString(USER_ID, ERROR);
    }

    public void setUserId(String id) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER_ID, id);
        editor.apply();
    }
}
