package org.CardGameContents;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of players");
        int numberOfPlayers = sc.nextInt();
        // Check if number of players is between 2 and 4
        if (numberOfPlayers < 2 || numberOfPlayers > 4) {
            System.out.println("Number of players should be between 2 and 4");
            System.exit(0);
        }

        // Create a new game
        GameEngine game = new GameEngine(numberOfPlayers);
        // Start the game
        game.playGame();

    }
}