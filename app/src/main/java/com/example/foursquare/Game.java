package com.example.foursquare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Game extends AppCompatActivity implements View.OnClickListener {


    private Button[][] GameBoard = new Button[4][4];
    private String[][] Move = new String[4][4];
    private int MoveCnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int x = 0; x < 4; x++) {
            for (int c = 0; c < 4; c++) {
                String buttonID = "button" + x + c;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                GameBoard[x][c] = findViewById(resID);
                GameBoard[x][c].setOnClickListener(this);
            }
        }

        Button buttonReset = findViewById(R.id.buttonretry);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResetButton();
            }
        });
    }

    @Override
    public void onClick(View scr) {
        if (!((Button) scr).getText().toString().equals("") && MoveCnt<2) {//checks if button is empty and if its a button on the outside blocks for first move of each player
            return;
        }
        if (!((Button) scr).getText().toString().equals("") || !((Button) scr).getText().toString().equals(" ")) {//checks if button is empty or not
            return;
        }
        if (MoveCnt%2==0) {
            ((Button) scr).setText("X");
            MoveCnt++;
        } else {
            ((Button) scr).setText("O");
            MoveCnt++;
        }
        if(win_checker()){
            Intent intent = new Intent(this, Winner.class);
            startActivity(intent);
        }
        if (MoveCnt==15){
            Intent intent = new Intent(this, Winner.class);
            startActivity(intent);
        }

    }

    private boolean win_checker() {
        for(int i = 0; i < 16; i++) {
            if (Move[i][0].equals((Move[i][2])) || Move[i][2].equals((Move[i][3])) && Move[i][1].equals(Move[i][2]) && !Move[i][2].equals("")) //checks horizontally
            {
                return true;
            }
            if (Move[0][i].equals((Move[2][i])) || Move[2][i].equals((Move[3][i])) && Move[1][i].equals((Move[2][i])) && !Move[2][i].equals("")) //checks vertically
            {
                return true;
            }
        }
        //checking diagonal wins
        if (Move[0][0].equals(Move[1][1]) || Move[3][3].equals(Move[2][2]) && Move[1][1].equals(Move[2][2]) && !Move[1][1].equals("")){
            return true;
        }
        if (Move[0][1].equals(Move[1][2]) && Move[1][2].equals(Move[2][3]) && !Move[1][2].equals("")){
            return true;
        }
        if (Move[1][0].equals(Move[2][1]) && Move[2][1].equals(Move[3][2]) && !Move[2][1].equals("")) {
            return true;
        }

        if (Move[3][0].equals(Move[2][1]) || Move[0][3].equals(Move[1][2]) && Move[1][2].equals(Move[2][1]) && !Move[2][1].equals("")){
            return true;
        }
        if (Move[2][0].equals(Move[1][1]) && Move[1][1].equals(Move[0][2]) && !Move[1][1].equals("")){
            return true;
        }
        if (Move[3][0].equals(Move[2][2]) && Move[2][2].equals(Move[1][3]) && !Move[1][3].equals("")){
            return true;
        }
        return false;
    }
    private void ResetButton(){
        for (int x = 0; x < 4; x++) {
            for (int c = 0; c < 4; c++) {
                GameBoard[x][c].setText("");
                Move[x][c] = ("");
            }
        }
        MoveCnt=0;
    }
}
