package com.example.umairzubair_15puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Winner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
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
