package work.ionut.blackjack;

import java.util.ArrayList;

public class Game {

    private int player1HandOldValue;
    private int player1HandNewValue;
    private int player2HandOldValue;
    private int player2HandNewValue;

    private Suit player1DealtCardSuit;
    private Rank player1DealtCardRank;
    private Suit player2DealtCardSuit;
    private Rank player2DealtCardRank;

    private ArrayList<Card> player1Hand;
    private ArrayList<Card> player2Hand;

    private Deck deck = new Deck();

    private Hand hand1 = new Hand(deck);
    private Hand hand2 = new Hand(deck);

    private Player player1;
    private Player player2;

    private Rule rule = new Rule();

    Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.player1Hand = new ArrayList<>();
        this.player2Hand = new ArrayList<>();
    }

    Player getPlayer1() {
        return this.player1;
    }

    Player getPlayer2() {
        return this.player2;
    }

    public Hand getPlayer1Hand() {
        return this.player1.getHand();
    }

    public Hand getPlayer2Hand() {
        return this.player2.getHand();
    }

    ArrayList<Card> dealPlayer1Card() {
        player1Hand = hand1.buildHand();
        Player player1  = new Player("Player1", hand1);

        player1DealtCardSuit = hand1.getCardSuit();
        player1DealtCardRank = hand1.getCardRank();

        player1Hand = hand1.getCardsInHand();
        for (Card card:player1Hand) {
            Suit suit = card.getSuit();
            Rank rank = card.getRank();
            int cardValue = card.getValue(rank);
        }

        player1HandNewValue = player1HandOldValue + hand1.getCardValue();
        player1HandOldValue = player1HandNewValue;

        return player1Hand;
    }

    int getPlayer1HandNewValue() {
        return player1HandNewValue;
    }

    Suit getplayer1DealtCardSuit() {
        return this.player1DealtCardSuit;
    }

    Rank getplayer1DealtCardRank() {
        return this.player1DealtCardRank;
    }

    int getPlayer1HandSize() {
        return player1Hand.size();
    }

    ArrayList<Card> dealPlayer2Card() {
        player2Hand = hand2.buildHand();
        Player player2  = new Player("Player2", hand2);
        String player2Name = player2.getName();

        player2DealtCardSuit = hand2.getCardSuit();
        player2DealtCardRank = hand2.getCardRank();

        player2Hand = hand2.getCardsInHand();
        for (Card card:player2Hand) {
            Suit suit = card.getSuit();
            Rank rank = card.getRank();
            int cardValue = card.getValue(rank);
        }

        player2HandNewValue = player2HandOldValue + hand2.getCardValue();
        player2HandOldValue = player2HandNewValue;

        return player2Hand;
    }

    int getPlayer2HandNewValue() {
        return player2HandNewValue;
    }

    Suit getplayer2DealtCardSuit() {
        return this.player2DealtCardSuit;
    }

    Rank getplayer2DealtCardRank() {
        return this.player2DealtCardRank;
    }

    int getPlayer2HandSize() {
        return player2Hand.size();
    }

    int getResult() {
        player1HandNewValue = getPlayer1HandNewValue();
        player2HandNewValue = getPlayer2HandNewValue();

        String result = rule.getResult(player1HandNewValue, player2HandNewValue);

        if(result.equals("Player1"))
            return 1;
        else if (result.equals("Player2"))
            return 2;

        return 0;
    }

    String getCard(int i)
    {
        Card work = player2Hand.get(i);
        return String.valueOf(work.getRank()+" "+ work.getSuit());
    }

}