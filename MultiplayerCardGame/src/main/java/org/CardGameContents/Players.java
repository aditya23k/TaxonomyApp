package org.CardGameContents;

import lombok.Getter;

import java.util.*;

@Getter
public class Players {

    private int id;
    private ArrayList<Card> pHand= new ArrayList<>();

    public Players(int id){
        this.id=id;

    }
    public void add(Card card){
        pHand.add(card);
    }
    public void remove(Card card){
        pHand.remove(card);
    }






}
