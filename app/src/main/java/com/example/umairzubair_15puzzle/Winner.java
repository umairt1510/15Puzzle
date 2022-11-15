package com.example.umairzubair_15puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;

public class Winner extends AppCompatActivity {

    private Chronometer chronometer;
    TextView Counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
        chronometer = findViewById(R.id.chronometer2);
        Counter = findViewById(R.id.Moves2);
        String moves = getIntent().getStringExtra("count");
        String timer = getIntent().getStringExtra("timer");
        chronometer.setText(timer + "");
        Counter.setText(moves + "");
    }
    public void onClickRestart(View View){
        Intent i = new Intent(this, GameScreen.class);
        startActivity(i);
    }
    public void onClickExit(View View){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}