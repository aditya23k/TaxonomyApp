package org.CardGameContents;

import java.util.*;

public class GameState {
    private ArrayList<Players> players;
    private ArrayList<Card> deck;
    private Stack<Card> discard;
    private Stack<Card> draw;

    public GameState(ArrayList<Players> players, ArrayList<Card> deck, Stack<Card> discard, Stack<Card> draw) {
        this.players = players;
        this.deck = deck;
        this.discard = discard;
        this.draw = draw;
    }

    public void play(int playerIndex, Card card) {
        if(!validateMove(card)){
            throw new UnsupportedOperationException("Illegal move");
        }
        players.get(playerIndex).remove(card);
        discard.push(card);
    }

    private boolean validateMove(Card card) {
        // Validate if the move is valid or not.
        // If the move is valid, return true, else return false.
        Card discardedCard = discard.peek();
        return card.getSuite() == discardedCard.getSuite()
                || card.getVal() == discardedCard.getVal();
    }

    public ArrayList<Integer> getValidMoves(int playerIndex){
        ArrayList<Integer> validMoves = new ArrayList<>();
        int index = 0;
        for (Card card : players.get(playerIndex).getHand()) {
            if(validateMove(card)){
                validMoves.add(index);
            }
            index++;
        }
        return validMoves;
    }

    public boolean canDraw(int playerIndex){
        for (Card card : players.get(playerIndex).getHand()) {
            if(validateMove(card)){
                return false;
            }
        }
        return true;
    }
}
