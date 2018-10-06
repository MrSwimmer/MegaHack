package com.memebattle.megahack.main.activity.note;

import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.memebattle.megahack.R;

public class NoteActivity extends MvpAppCompatActivity implements NoteActivityView {
    @InjectPresenter
    NoteActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
    }
}
