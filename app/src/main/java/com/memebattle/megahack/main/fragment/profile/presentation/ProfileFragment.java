package com.memebattle.megahack.main.fragment.profile.presentation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.memebattle.megahack.R;
import com.memebattle.megahack.main.fragment.profile.data.model.Profile;

public class ProfileFragment extends MvpAppCompatFragment implements ProfileFragmentView{
    @InjectPresenter
    ProfileFragmentPresenter presenter;

    Switch aSwitch;
    boolean online;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        presenter.getProfile();
        aSwitch = view.findViewById(R.id.switch1);
        aSwitch.setChecked(online);
        aSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            online = isChecked;
            if(isChecked)
                aSwitch.setText("Online");
            else
                aSwitch.setText("Offline");
        });
        return view;
    }

    @Override
    public void setProfile(Profile profile) {

    }
}
