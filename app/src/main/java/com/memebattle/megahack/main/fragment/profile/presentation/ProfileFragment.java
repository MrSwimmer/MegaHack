package com.memebattle.megahack.main.fragment.profile.presentation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.memebattle.megahack.App;
import com.memebattle.megahack.R;
import com.memebattle.megahack.auth.fragment.core.data.model.SignRequest;
import com.memebattle.megahack.auth.fragment.core.data.model.UserSignIn;
import com.memebattle.megahack.auth.fragment.core.data.model.UserSignUp;
import com.memebattle.megahack.auth.fragment.core.domain.ApiAuthService;
import com.memebattle.megahack.main.fragment.profile.data.model.Profile;
import com.memebattle.megahack.main.fragment.profile.data.model.ProfileStatus;
import com.memebattle.megahack.main.fragment.profile.domain.ApiProfileService;

import java.util.ArrayList;


public class ProfileFragment extends MvpAppCompatFragment implements ProfileFragmentView{
    @InjectPresenter
    ProfileFragmentPresenter presenter;
    TextView emailTextView;
    TextView nameTextView;
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    CheckBox checkBox4;
    Switch aSwitch;
    boolean online;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        emailTextView = view.findViewById(R.id.email);
        checkBox1 = view.findViewById(R.id.checkBox);
        checkBox2 = view.findViewById(R.id.checkBox2);
        checkBox3 = view.findViewById(R.id.checkBox3);
        checkBox4 = view.findViewById(R.id.checkBox4);
        nameTextView = view.findViewById(R.id.name);
        presenter.getProfile();
        aSwitch = view.findViewById(R.id.switch1);
        aSwitch.setChecked(online);
        aSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            online = isChecked;
            if(isChecked) {
                aSwitch.setText("Online");
                App.apiProfileService.setStatus(new ApiProfileService.ProfileStatusCallback() {
                    @Override
                    public void onSuccess(String string) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                }, new ProfileStatus(true, App.settingsService.getUserId()));
            }
            else{
                aSwitch.setText("Offline");
                App.apiProfileService.setStatus(new ApiProfileService.ProfileStatusCallback() {
                    @Override
                    public void onSuccess(String string) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                }, new ProfileStatus(false, App.settingsService.getUserId()));
            }
        });
        return view;
    }

    @Override
    public void setProfile(Profile profile) {
        emailTextView.setText(profile.email);
        if (profile.problems.get(0).equals("1")) checkBox1.isChecked();
        if (profile.problems.get(1).equals("2")) checkBox2.isChecked();
        if (profile.problems.get(2).equals("3")) checkBox3.isChecked();
        if (profile.problems.get(3).equals("4")) checkBox4.isChecked();
        if (profile.status) aSwitch.setChecked(true);
        if (profile.status) aSwitch.setChecked(false);
        nameTextView.setText(profile.name);

    }
}
