package org.CardGameContents;

import lombok.Getter;

@Getter
public class Card {

    private CardSuite suite;//card suite

    private int val; //card value

    //constructor for the card
    public Card(CardSuite suite,int val){
        this.suite= suite;
        this.val=val;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suite=" + suite +
                ", val=" + val +
                '}';
    }
}
