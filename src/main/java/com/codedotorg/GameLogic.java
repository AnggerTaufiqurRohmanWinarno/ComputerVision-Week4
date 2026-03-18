package com.codedotorg;

import java.util.Random;

public class GameLogic {

    /** Whether or not the game is over */
    private boolean gameOver;

    /**
     * Constructor for the GameLogic class.
     * Initializes the gameOver variable to false.
     */
    public GameLogic() {
        gameOver = false;
    }

    /**
     * Returns a random choice of "rock", "paper", or
     * "scissors" for the computer player.
     * 
     * @return a String representing the computer's choice
     */
    public String getComputerChoice() {
        String[] choices = {"rock", "paper", "scissors"};
        Random rand = new Random();
        return choices[rand.nextInt(3)];
    }

    /**
     * Determines the winner of a rock-paper-scissors game
     */
    public String determineWinner(String predictedClass, String computerChoice) {

        // Jika seri
        if (predictedClass.equals(computerChoice)) {
            return "User: " + predictedClass + 
                   " | Computer: " + computerChoice + 
                   " → " + getTieResult();
        }

        // Kondisi user menang
        if (
            (predictedClass.equals("rock") && computerChoice.equals("scissors")) ||
            (predictedClass.equals("paper") && computerChoice.equals("rock")) ||
            (predictedClass.equals("scissors") && computerChoice.equals("paper"))
        ) {
            return "User: " + predictedClass + 
                   " | Computer: " + computerChoice + 
                   " → " + getUserWinnerResult();
        }

        // Selain itu komputer menang
        return "User: " + predictedClass + 
               " | Computer: " + computerChoice + 
               " → " + getComputerWinnerResult();
    }

    /**
     * Tie result
     */
    public String getTieResult() {
        gameOver = true;
        return "It's a Tie!";
    }

    /**
     * User win
     */
    public String getUserWinnerResult() {
        gameOver = true;
        return "You Win!";
    }

    /**
     * Computer win
     */
    public String getComputerWinnerResult() {
        gameOver = true;
        return "Computer Wins!";
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void resetLogic() {
        gameOver = false;
    }
}