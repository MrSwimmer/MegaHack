package com.memebattle.megahack.auth.activity;


import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.memebattle.megahack.R;

public class AuthActivity extends AppCompatActivity {
    FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        
    }
}
