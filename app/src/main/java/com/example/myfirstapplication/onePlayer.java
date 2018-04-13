package com.example.myfirstapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class onePlayer extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"; // what does .MESSAGE mean?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_player);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        RockPaperScissorsLizardSpock myGame = new RockPaperScissorsLizardSpock();

        String playerMove;
        String computerMove;
        String resultsDisplay;
        String printPlayer;
        String whoWins;

        playerMove = editText.getText().toString();
        // error-trap here for wrong values
        if(!myGame.isValidMove(playerMove))
        {
            invalidAlert();
        }
        else
        {
            myGame.makeMove(playerMove); // static/non-static

            printPlayer = "You played " + playerMove + ".";
            computerMove = ("Computer played " + myGame.getComputerMove() + ".");
            resultsDisplay = myGame.getResults();
            whoWins = Integer.toString(myGame.determineWinner());

            String[] results = new String[4];
            results[0] = printPlayer;
            results[1] = computerMove;
            results[2] = resultsDisplay;
            results[3] = whoWins;

            intent.putExtra(EXTRA_MESSAGE, results);

            startActivity(intent);
        }
    }

    public void invalidAlert()
    {
        // create an alert dialog
        AlertDialog.Builder invalid = new AlertDialog.Builder(this);

        // setting message and title
        invalid.setMessage("That's not a valid move - try again!\n" +
                "(Make sure the first letter is capitalized!)");
        invalid.setTitle("Invalid Input");

        // setting icon
        invalid.setIcon(R.drawable.ic_launcher_background);

        // setting ok button
        invalid.setNeutralButton("OK", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(getApplicationContext(), "Re-submit your answer", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = invalid.create();
        alertDialog.show();
    }
}