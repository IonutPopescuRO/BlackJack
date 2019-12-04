package work.ionut.blackjack;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cardsInHand;
    private Suit suit;
    private Rank rank;
    private int cardValue;
    private int handValue;

    private Deck deck = null;

    Hand(Deck deck) {
        this.cardsInHand = new ArrayList<>();
        this.deck = deck;
    }

    ArrayList<Card> buildHand() {
        this.handValue = 0;
        Card newCard = deck.dealRandomCard();
        this.cardsInHand.add(newCard);
        for (Card card:cardsInHand) {
            this.suit = card.getSuit();
            this.rank = card.getRank();
            this.cardValue = card.getValue(rank);
            this.handValue = this.handValue + this.cardValue;
        }
        return cardsInHand;
    }

    Suit getCardSuit() {
        return this.suit;
    }

    Rank getCardRank() {
        return this.rank;
    }

    int getCardValue() {
        return this.cardValue;
    }

    public int getHandValue() {
        return this.handValue;
    }

    int getHandSize() {
        int handSize = cardsInHand.size();
        return handSize;
    }

    ArrayList<Card> getCardsInHand() {
        return this.cardsInHand;
    }
}