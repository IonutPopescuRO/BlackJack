package work.ionut.blackjack;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

class Deck {
    private ArrayList<Card> deck;
    private Random randomGenerator = new Random();

    Deck() {
        this.deck = new ArrayList<>();
        createDeck();
        Log.w("app", "TEST: se creaza un pachet");
    }

    private void createDeck(){
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add( new Card(suit, rank));
            }
        }
    }

    Card dealRandomCard() {
        int i = randomGenerator.nextInt(deck.size());
        Card selected = deck.get(i);
        deck.remove(i);//Nu dam aceeasi cate de doua ori

        Log.w("app", "TEST: marimea pachetului:" + deck.size());
        return selected;
    }
}