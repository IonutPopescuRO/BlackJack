package work.ionut.blackjack;

public class Player {

    private String name;
    private Hand hand;

    public Player() {
    }

    Player(String name, Hand hand) {
        this.name = name;
        this.hand = hand;
    }

    String getName() {
        return this.name;
    }

    public void setName(String newPlayer) {
        this.name = name;
    }

    Hand getHand() {
        return this.hand;
    }
}