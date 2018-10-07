package com.memebattle.megahack.auth.fragment.sign_in;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.memebattle.megahack.R;
import com.memebattle.megahack.auth.fragment.sign_up.SignUpFragment;
import com.memebattle.megahack.main.activity.MainActivity;

public class SignInFragment extends MvpAppCompatFragment implements SignInFragmentView {
    @InjectPresenter
    SignInFragmentPresenter presenter;
    EditText mailEditText;
    EditText passwordEditText;
    Button regButton;
    Button nextButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        mailEditText = view.findViewById(R.id.editTextMail);
        passwordEditText = view.findViewById(R.id.editTextPassword);
        regButton = view.findViewById(R.id.buttonReg);
        nextButton = view.findViewById(R.id.buttonNext);
        regButton.setOnClickListener(view1 -> {
            FragmentTransaction fragmentTransaction;
            fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            SignUpFragment signUpFragment = new SignUpFragment();
            fragmentTransaction.replace(R.id.containerAuth, signUpFragment);
            fragmentTransaction.commit();
        });
        nextButton.setOnClickListener(view2 -> {
            getData();
        });
        return view;
    }

    @Override
    public void getData() {
        String mail;
        String password;
        mail = mailEditText.getText().toString();
        password = passwordEditText.getText().toString();
        presenter.signIn(mail, password);
    }

    @Override
    public void nextActivity() {
        startActivity(new Intent(getActivity(), MainActivity.class));
        getActivity().finish();
    }
}
