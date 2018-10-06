package com.memebattle.megahack.auth.fragment.sign_up;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.memebattle.megahack.R;

import java.util.ArrayList;
import java.util.List;

public class SignUpFragment extends MvpAppCompatFragment implements SignUpFragmentView {
    @InjectPresenter
    SignUpFragmentPresenter presenter;
    private EditText nameEditText;
    private EditText mailEditText;
    private EditText passwordEditText;
    private CheckBox firstCheckBox;
    private CheckBox secondCheckBox;
    private CheckBox thirdCheckBox;
    private CheckBox fourthCheckBox;
    private Button button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        nameEditText = view.findViewById(R.id.EditTextName);
        mailEditText = view.findViewById(R.id.EditTextEmail);
        passwordEditText = view.findViewById(R.id.EditTextPassword);
        firstCheckBox = view.findViewById(R.id.checkBox);
        secondCheckBox = view.findViewById(R.id.checkBox2);
        thirdCheckBox = view.findViewById(R.id.checkBox3);
        fourthCheckBox = view.findViewById(R.id.checkBox4);
        button = view.findViewById(R.id.signUp);
        button.setOnClickListener(view1 -> {
            getData();
        });
        return view;
    }

    @Override
    public void getData() {
        String name;
        String mail;
        String password;
        ArrayList<String> type = new ArrayList<>();
        name = nameEditText.getText().toString();
        mail = mailEditText.getText().toString();
        password = passwordEditText.getText().toString();
        if (firstCheckBox.isChecked()) type.add("1");
        if (secondCheckBox.isChecked()) type.add("2");
        if (thirdCheckBox.isChecked())type.add("3");
        if (fourthCheckBox.isChecked())type.add("4");
        presenter.signUp(name,mail,password, type);
    }
}