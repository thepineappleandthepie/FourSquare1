package com.example.foursquare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Name extends AppCompatActivity {
    private EditText playerX;
    private EditText playerO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        playerX=  findViewById(R.id.editTextTextPersonName);
        playerO = findViewById(R.id.editTextTextPersonName2);
    }
    public void playButtonClick( View view){
        String playerXName = playerX.getText().toString();
        String playerOName = playerO.getText().toString();

        Intent intent = new Intent(this, Game.class);
        intent.putExtra("GivenNames", new String[] {playerXName, playerOName} );
        startActivity(intent);
    }

}