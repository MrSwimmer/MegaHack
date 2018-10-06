package com.memebattle.megahack.main.activity;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.memebattle.megahack.R;
import com.memebattle.megahack.main.fragment.profile.presentation.ProfileFragment;
import com.memebattle.megahack.main.fragment.request.presentation.RequestFragment;
import com.memebattle.megahack.main.fragment.settings.presentation.SettingsFragment;


public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RequestFragment requestFragment = new RequestFragment();
        ProfileFragment profileFragment = new ProfileFragment();
        SettingsFragment settingsFragment = new SettingsFragment();

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.container, requestFragment);
        fragmentTransaction.commit();

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.request);

        bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {

            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            switch (menuItem.getItemId()) {
                case R.id.auth: {
                    fragmentTransaction.replace(R.id.container, profileFragment);
                    break;
                }
                case R.id.request: {
                    fragmentTransaction.replace(R.id.container, requestFragment);
                    break;
                }
                case R.id.settings: {
                    fragmentTransaction.replace(R.id.container, settingsFragment);
                    break;
                }

            }
            fragmentTransaction.commit();
            return true;
        });
    }


}
