package com.example.myfirstapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

public class RockPaperScissorsLizardSpock extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_paper_scissors_lizard_spock);
    }

    private static int _p1Move;
    private static int _p2Move;

    /**
     * Constructs a game of Rock Paper Scissors Spock.
     */
    public RockPaperScissorsLizardSpock()
    {
        // initializing instance variables
        _p1Move = 0;
        _p2Move = 0;
    }

    /**
     * Converts the user's input to the corresponding numerical value.
     * @param p1Move the user's input
     */
    public static void makeMove(String p1Move)
    {
        switch (p1Move)
        {
            case "Rock": _p1Move = 0;
                break;
            case "Paper": _p1Move = 1;
                break;
            case "Scissors": _p1Move = 2;
                break;
            case "Lizard": _p1Move = 3;
                break;
            case "Spock": _p1Move = 4;
                break;
        }
    }

    /**
     * Converts both players' inputs to their corresponding numerical values.
     * @param p1Move player one's input
     * @param p2Move player two's input
     */
    public static void makeMove(String p1Move, String p2Move)
    {
        makeMove(p1Move);

        switch (p2Move)
        {
            case "Rock": _p2Move = 0;
                break;
            case "Paper": _p2Move = 1;
                break;
            case "Scissors": _p2Move = 2;
                break;
            case "Lizard": _p2Move = 3;
                break;
            case "Spock": _p2Move = 4;
                break;
        }
    }

    /**
     * Returns the winner of the round - player one, player two/computer,
     * or a tie.
     * @return the winner of the round
     */
    public int determineWinner()
    {
        int[][] winner =
                {
                        { 0, 2, 1, 1, 2 },
                        { 1, 0, 2, 2, 1 },
                        { 2, 1, 0, 1, 2 },
                        { 2, 1, 2, 0, 1 },
                        { 1, 2, 1, 2, 0 }
                };

        return winner[_p1Move][_p2Move];
    }

    /**
     * Returns a string with the results of the match.
     * @return match results in string form
     */
    public String getResults()
    {
        // method NYD
        String[][] winner =
                {
                        { "Rock ties rock!", "Paper covers rock!", "Rock smashes scissors!",
                                "Rock crushes lizard!", "Spock vaporizes rock!" },
                        { "Paper covers rock!", "Paper ties paper!",
                                "Scissors cuts paper!", "Lizard eats paper!",
                                "Paper disproves Spock!" },
                        { "Rock smashes scissors!", "Scissors cuts paper!",
                                "Scissors ties scissors!", "Scissors decapitates lizard!",
                                "Spock smashes scissors!" },
                        { "Rock crushes lizard!", "Lizard eats paper!",
                                "Scissors decapitates lizard!", "Lizard ties lizard!",
                                "Lizard poisons Spock!" },
                        { "Spock vaporizes rock!", "Paper disproves Spock!",
                                "Spock smashes scissors!", "Lizard poisons Spock!",
                                "Spock ties Spock!" }
                };

        return winner[_p1Move][_p2Move];
    }

    /**
     * Gets a random move from the computer and converts it to a string output.
     * @return string output of the computer's move
     */
    public String getComputerMove()
    {
        String[] computerInput = new String[] {"Rock", "Paper",
                "Scissors", "Lizard", "Spock"};
        int compMove;
        Random rand = new Random();

        compMove = rand.nextInt(5); // 5 for the 5 options of RPSLS
        _p2Move = compMove;
        return computerInput[compMove];
    }

    /**
     * Determines whether a move is valid and returns true or false.
     * @param move the user's input
     * @return true or false, depending on whether the move is valid
     */
    public boolean isValidMove(String move)
    {
        boolean isValid = false;
        String[] validInput = new String[] {"Rock", "Paper",
                "Scissors", "Lizard", "Spock"};

        for (int i = 0; i < validInput.length; i++) // i don't think i should use a for loop here
        {
            if(validInput[i].equals(move))
            {
                isValid = true;
            }
        }

        return isValid;
    }
}
