package com.example.myfirstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"; // what does .MESSAGE mean?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button singlePlayerButton = (Button) findViewById(R.id.button);
    }

    // Displays "Pick a Game" at the top of the menu screen
    public void menu(View view) {

        TextView textView5 = findViewById(R.id.textView5);
        textView5.setText("Pick a Game:");

    }

    // Called when player presses "One Player"
    public void singlePlayer(View view) {
        Intent intent = new Intent(this, onePlayer.class);

        startActivity(intent);
    }

    // Called when player presses "Two Players"
    public void twoPlayer(View view) {
        Intent intent = new Intent(this, twoPlayer.class);

        startActivity(intent);
    }

    /* public void GTW(View view) {
        Intent intent = new Intent(this, globalThermonuclearWar.class);

        startActivity(intent);
    } */
}