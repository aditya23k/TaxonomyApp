//assign the cards ...loop
//shuffle  function

package org.CardGameContents;
import lombok.Getter;
import java.util.*;

@Getter
public class Deck {

    public static ArrayList<Card> deck;

    public static ArrayList<Card>createDeck (){
        deck= new ArrayList<>();
        for(CardSuite suite: CardSuite.values()){
            //for each suite , we assign the value of the ranks,
            //ace gets 1, jack get 11,king gets 12, queen gets 13
            for(int i=1;i<=13;i++){
                deck.add(new Card(suite,i));
            }
        }
        Collections.shuffle(deck);
        return deck;
    }


    /*
    public static void main(String[] args){

        ArrayList<Card> nDeck= Deck();
        for(Card i: nDeck){
            i.printCard();
        }
    }
    */
}
