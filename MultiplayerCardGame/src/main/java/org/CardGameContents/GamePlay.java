package org.CardGameContents;

import java.io.IOException;
import java.util.*;

import org.CardGameContents.*;

public class GamePlay {
    //arraylist of players
    //deck of cards- discard and draw pile--this will be a stack

    //hand of each player
    //deal function
    //basic game play function

    private static ArrayList<Players> players;
    private static ArrayList<Card> deck;
    private static Stack<Card> discard;
    private static Stack<Card> draw;

    /**
     * Constructs a new object.
     */
    public static void play() throws Exception{
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter number of players");
        int pl=sc.nextInt();
        if(pl<2 || pl>4) throw new Exception("Invalid numbers, input should be between 2 and 4");
        //creating the deck
        deck=Deck.createDeck();

        //creating players list and adding their hands
        players = new ArrayList<>();
        for(int i=1;i<=pl;i++){
            Players p=new Players(i);
            int t=5;
            while(t>0){
                p.add(deck.get(deck.size()-1));
                deck.remove(deck.size()-1);
            }
            players.add(p);
        }
        //creating a discard pile and draw pile
        discard=new Stack<>();
        draw= new Stack<>();
        for(Card c:deck){
            draw.push(deck.get(deck.size()-1));
            deck.remove(deck.size()-1);
        }
        //adding the top card of the draw to the discard pile to get the game started
        discard.push(draw.pop());

        int turn=0;//player turn
        int direction=1;//order of play-for bonus question
        int cardAdd=1;
        while(draw.size()>0){
            turn%=pl;

            boolean match=false;
            int currcard=-1;
            Card topCard= discard.peek();
            for(Card plCurrCard: players.get(turn).getPHand()){
                if((plCurrCard.getVal()== topCard.getVal())||(plCurrCard.getSuite()== topCard.getSuite())){
                    players.get(turn).remove(plCurrCard);
                    discard.push(plCurrCard);
                    match=true;
                    currcard=plCurrCard.getVal();
                    break;
                }
            }
            if(match==false){
                while(cardAdd>0){
                    players.get(turn).add(draw.pop());
                    cardAdd--;
                }
                cardAdd=1;
            }
            if(match==true && players.get(turn).getPHand().size() == 0){
                System.out.println(players.get(turn).getId()+" has won the match");
                System.exit(0);
            }


        }
        System.out.println("Match ended in Draw!");

    }
    //tested the output - out of bounds exception error

    public static void main(String[] args) throws Exception{
        GamePlay.play();
    }






}
