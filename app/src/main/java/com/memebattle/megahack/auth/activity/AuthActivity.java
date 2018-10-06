package com.memebattle.megahack.auth.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.memebattle.megahack.App;
import com.memebattle.megahack.R;
import com.memebattle.megahack.auth.fragment.sign_in.SignInFragment;
import com.memebattle.megahack.auth.fragment.sign_up.SignUpFragment;
import com.memebattle.megahack.main.activity.MainActivity;

public class AuthActivity extends AppCompatActivity {
    FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        fragmentTransaction = getSupportFragmentManager().beginTransaction();

        SignUpFragment signUpFragment = new SignUpFragment();
        String launch = App.settingsService.getUserId();

        if (!launch.equals("error")) {
            startActivity(new Intent(AuthActivity.this, MainActivity.class));
        }else{
            fragmentTransaction.add(R.id.containerAuth, signInFragment);
            fragmentTransaction.commit();
        }
    }
}
