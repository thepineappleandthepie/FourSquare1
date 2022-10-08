package com.example.foursquare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void playbuttontap(View scr){
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
    }
    public void rulebuttontap(View scr){
        Intent intent = new Intent(this, Rule.class);
        startActivity(intent);
    }
}