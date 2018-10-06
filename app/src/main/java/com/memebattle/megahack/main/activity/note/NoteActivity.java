package com.memebattle.megahack.main.activity.note;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.memebattle.megahack.R;

import org.greenrobot.eventbus.EventBus;

public class NoteActivity extends MvpAppCompatActivity implements NoteActivityView {
    @InjectPresenter
    NoteActivityPresenter presenter;
    Button answerButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_note);
        answerButton = findViewById(R.id.buttonAnswer);
        answerButton.setOnClickListener(view -> EventBus.getDefault().post(true));
    }
}
