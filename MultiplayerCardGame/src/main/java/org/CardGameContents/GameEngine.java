package org.CardGameContents;

import java.util.*;

public class GameEngine {
    private int numberOfPlayers;
    private ArrayList<Player> players;
    private Stack<Card> discard;
    private GameState gameState;
    private Deck deck;
    private int playerIndex;
    private boolean counter;

    public GameEngine(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        players = new ArrayList<Player>();
        discard = new Stack<Card>();
        deck = new Deck();
        deck.shuffle();
        playerIndex = 0;
        counter = true;
        gameState = new GameState(players, discard);
    }

    private void startGame() {
        System.out.println("Game Started");
        initialisePlayers();
        distributeCards();
    }

    public void playGame() {
        /*
        Each player starts with a hand of 5 cards.

        The game starts with a deck of 52 cards ( a standard deck of playing cards).

        Players take turns playing cards from their hand, following a set of rules that define what cards can be played when.

        A player can only play a card if it matches either the suit or the rank of the top card on the discard pile.

        If a player cannot play a card, they must draw a card from the draw pile.
        If the draw pile is empty, the game ends in a draw and no player is declared a winner..

        The game ends when one player runs out of cards who is declared the winner.

        BONUS: Aces, Kings, Queens and Jack are action cards. When one of these is played the following actions occur:

        Ace(A): Skip the next player in turn

        Kings(K): Reverse the sequence of who plays next

        Queens(Q): +2

        Jacks(J): +4

        NOTE: actions are not stackable i.e. if Q is played by player 1 then player two draws two cards
        and cannot play a Q from his hand on that turn even if available
         */
        startGame();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            //TODO: Implement game logic
            System.out.println("Top of discard pile: " + discard.peek());
            Player currentPlayer = players.get(playerIndex);
            System.out.println("Player " + currentPlayer.getPlayerId() + " turn");
            System.out.println("Your hand: " + currentPlayer.getHand());

            // Ask the player to play the card
            int cardIndex = scanner.nextInt();
            try{

                Card card = currentPlayer.getHand().get(cardIndex);
                gameState.play(playerIndex, card);
            }
            catch(Exception e){
                System.out.println(e);
                continue;
            }

            if(currentPlayer.getHand().size() == 0){
                System.out.println("We have a winner " + currentPlayer.getPlayerId());
                endGame();
                break;
            }
        }
    }

    private void endGame() {
        System.out.println("Game Ended");
    }

    private void distributeCards() {
        for (int i = 0; i < 5; i++) {
            for (Player p : players) {
                p.addCard(deck.draw());
            }
        }
    }

    private void initialisePlayers() {
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player(i));
        }
    }

}
