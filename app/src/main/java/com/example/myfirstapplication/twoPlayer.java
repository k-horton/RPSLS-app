package com.example.myfirstapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class twoPlayer extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"; // what does .MESSAGE mean?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_player);
    }

    /**
     * Runs a player vs. player game.
     * @param view i have no idea what this is
     */
    public void makeMoves(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        EditText editText3 = (EditText) findViewById(R.id.editText3);
        RockPaperScissorsLizardSpock myGame = new RockPaperScissorsLizardSpock();

        String playerOneMove;
        String playerTwoMove;
        String resultsDisplay;
        String printPlayerOne;
        String printPlayerTwo;
        String whoWins;

        // takes in player one's move
        playerOneMove = editText2.getText().toString();
        playerTwoMove = editText3.getText().toString();
        // error-trap here for wrong values
        if(!myGame.isValidMove(playerTwoMove) || !myGame.isValidMove(playerOneMove))
        {
            invalidAlert();
        }
        else {

            myGame.makeMove(playerOneMove, playerTwoMove);

            printPlayerOne = "Player One played " + playerOneMove + ".";
            printPlayerTwo = ("Player Two played " + playerTwoMove + ".");
            resultsDisplay = myGame.getResults();
            whoWins = Integer.toString(myGame.determineWinner());

            String[] results = new String[4];
            results[0] = printPlayerOne;
            results[1] = printPlayerTwo;
            results[2] = resultsDisplay;
            results[3] = whoWins;

            intent.putExtra(EXTRA_MESSAGE, results);

            startActivity(intent);
        }
    }

    /**
     * Displays an alert telling the user to re-enter valid input.
     * @return alert dialog
     */
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
