package com.memebattle.megahack.auth.fragment.sign_in;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.memebattle.megahack.R;

public class SignInFragment extends MvpAppCompatFragment implements SignInFragmentView {
    @InjectPresenter
    SignInFragmentPresenter presenter;
    EditText mailEditText;
    EditText passwordEditText;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        mailEditText = view.findViewById(R.id.editTextMail);
        passwordEditText = view.findViewById(R.id.editTextPassword);
        return view;
    }

    @Override
    public void successSignIn() {
        presenter.saveSharedPreference();
    }
}
