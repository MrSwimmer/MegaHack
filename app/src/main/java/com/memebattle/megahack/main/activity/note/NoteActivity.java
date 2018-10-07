package com.memebattle.megahack.main.activity.note;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.memebattle.megahack.App;
import com.memebattle.megahack.R;
import com.memebattle.megahack.main.activity.MainActivity;


public class NoteActivity extends MvpAppCompatActivity implements NoteActivityView {
    @InjectPresenter
    NoteActivityPresenter presenter;
    Button answerButton;
    TextView textViewName;
    TextView textViewProblem;
    TextView textViewText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_note);
        answerButton = findViewById(R.id.buttonAnswer);
        textViewName = findViewById(R.id.textViewName);
        textViewProblem = findViewById(R.id.textViewProblem);
        textViewText = findViewById(R.id.textViewText);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        Log.i("TAG",name);
        String problem = intent.getStringExtra("problem");
        String text = intent.getStringExtra("text");
        textViewText.setText(text);
        textViewProblem.setText(problem);
        textViewName.setText(name);
        answerButton.setOnClickListener(view -> {
            App.deleteItem=problem;
            startActivity(new Intent(NoteActivity.this,MainActivity.class));
            this.finish();
        });
    }
}
