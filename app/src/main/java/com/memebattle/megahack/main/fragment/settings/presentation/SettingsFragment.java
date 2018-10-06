package com.memebattle.megahack.main.fragment.settings.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.memebattle.megahack.App;
import com.memebattle.megahack.R;
import com.memebattle.megahack.auth.activity.AuthActivity;

public class SettingsFragment extends MvpAppCompatFragment implements SettingsFragmentView {
    @InjectPresenter
    SettingsFragmentPresenter presenter;
    TextView outTextView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        outTextView = view.findViewById(R.id.textViewOut);
        outTextView.setOnClickListener(view1 -> {
            App.settingsService.setUserId("error");
            startActivity(new Intent(getActivity(), AuthActivity.class));
        });
        return view;
    }
}
