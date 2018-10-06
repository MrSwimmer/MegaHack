package com.memebattle.megahack.auth.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.memebattle.megahack.R;
import com.memebattle.megahack.auth.fragment.sign_up.SignUpFragment;
import com.memebattle.megahack.main.activity.MainActivity;

public class AuthActivity extends AppCompatActivity {
    FragmentTransaction fragmentTransaction;
    public static final String APP_PREFERENCES = "settings";
    public static final String ERROR = "error";
    public static final String USER_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        SignUpFragment signUpFragment = new SignUpFragment();
        String launch = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE).getString(USER_ID, ERROR);
        if (!launch.equals("error")) {
            startActivity(new Intent(AuthActivity.this, MainActivity.class));
        }else{
            fragmentTransaction.add(R.id.containerAuth, signUpFragment);
            fragmentTransaction.commit();
        }
    }
}
