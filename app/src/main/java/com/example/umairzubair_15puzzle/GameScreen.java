package com.example.umairzubair_15puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import java.util.*;

public class GameScreen extends AppCompatActivity {

    TextView count;
    int counter = -1;

    int[][] intGame = new int[4][4];
    Button[][] btnGame = new Button[4][4];
    ArrayList<Integer> intNums;

    int[][] intCheck = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,0,15}};
    private Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        chronometer = findViewById(R.id.chronometer);
        count = (TextView) findViewById(R.id.Moves);
        setGame();
        setButton();
        updateGame();
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.start();
    }

    public void toFirst(View View) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void onClickInstruction(View View) {
        Intent i = new Intent(this, Instructions.class);
        startActivity(i);
    }

    public void Restart(View view){
        setGame();
        updateGame();
        counter = 0;
        count.setText(counter + "");
        chronometer.setBase(SystemClock.elapsedRealtime());
    }
    public void setGame(){
        intNums = new ArrayList<>();

        for (int i = 0; i < 16; i++) {
            intNums.add(i);
        }

        Collections.shuffle(intNums);

        int intIndex = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                intGame[i][j] = intNums.get(intIndex);
                intIndex++;
            }
        }

        intGame = intCheck;

    }

    public void setButton(){
        btnGame[0][0] = findViewById(R.id.button1);
        btnGame[0][1] = findViewById(R.id.button2);
        btnGame[0][2] = findViewById(R.id.button3);
        btnGame[0][3] = findViewById(R.id.button4);
        btnGame[1][0] = findViewById(R.id.button5);
        btnGame[1][1] = findViewById(R.id.button6);
        btnGame[1][2] = findViewById(R.id.button7);
        btnGame[1][3] = findViewById(R.id.button8);
        btnGame[2][0] = findViewById(R.id.button9);
        btnGame[2][1] = findViewById(R.id.button10);
        btnGame[2][2] = findViewById(R.id.button11);
        btnGame[2][3] = findViewById(R.id.button12);
        btnGame[3][0] = findViewById(R.id.button13);
        btnGame[3][1] = findViewById(R.id.button14);
        btnGame[3][2] = findViewById(R.id.button15);
        btnGame[3][3] = findViewById(R.id.button16);

    }

    public void updateGame(){

        for (int i = 0; i < 4 ; i++) {
            for (int j = 0; j < 4; j++) {
                btnGame[i][j].setText(intGame[i][j] + "");
                if(intGame[i][j] == 0)
                    btnGame[i][j].setText("");
            }
        }

        counter++;
        count.setText(counter + "");
        winCheck();
    }

    public void winCheck(){
        int[][] intWinGame = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 0}};

        boolean equalsCheck = true;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(intGame[i][j] != intWinGame[i][j])
                    equalsCheck = false;
            }
        }

        if(equalsCheck){
            chronometer.stop();
            Intent i = new Intent(this, Winner.class);
            String TotalCount = count.getText().toString();
            String TotalTimer  = chronometer.getText().toString();
            i.putExtra("count",TotalCount);
            i.putExtra("timer",TotalTimer);
            startActivity(i);
        }
    }

    public void changeTile(int x, int y){
        if(x > 0 && intGame[x - 1][y]== 0) {
            intGame[x-1][y] = intGame[x][y];
            intGame[x][y] = 0;
            updateGame();
        }
        else if(x < 3 && intGame[x + 1][y]== 0) {
            intGame[x + 1][y] = intGame[x][y];
            intGame[x][y] = 0;
            updateGame();
        }
        else if(y > 0 && intGame[x][y - 1]== 0) {
            intGame[x][y - 1] = intGame[x][y];
            intGame[x][y] = 0;
            updateGame();
        }
        else if(y < 3 && intGame[x][y + 1]== 0) {
            intGame[x][y + 1]  = intGame[x][y];
            intGame[x][y] = 0;
            updateGame();
        }
    }

    public void buttonClick1(View view){
        changeTile(0,0);
    }
    public void buttonClick2(View view){
        changeTile(0,1);
    }
    public void buttonClick3(View view){
        changeTile(0,2);
    }
    public void buttonClick4(View view){
        changeTile(0,3);
    }
    public void buttonClick5(View view){
        changeTile(1,0);
    }
    public void buttonClick6(View view){
        changeTile(1,1);
    }
    public void buttonClick7(View view){
        changeTile(1,2);
    }
    public void buttonClick8(View view){
        changeTile(1,3);
    }
    public void buttonClick9(View view){
        changeTile(2,0);
    }
    public void buttonClick10(View view){
        changeTile(2,1);
    }
    public void buttonClick11(View view){
        changeTile(2,2);
    }
    public void buttonClick12(View view){
        changeTile(2,3);
    }
    public void buttonClick13(View view){
        changeTile(3,0);
    }
    public void buttonClick14(View view){
        changeTile(3,1);
    }
    public void buttonClick15(View view){
        changeTile(3,2);
    }
    public void buttonClick16(View view){
        changeTile(3,3);
    }


}
