package org.CardGameContents;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Player {

    private final int playerId;
    private ArrayList<Card> hand;

    public Player(int id){
        this.playerId =id;
        hand = new ArrayList<>();
    }
    public void addCard(Card card){
        hand.add(card);
    }
    public void removeCard(Card card){
        hand.remove(card);
    }






}
