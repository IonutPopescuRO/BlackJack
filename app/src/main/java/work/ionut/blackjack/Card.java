package work.ionut.blackjack;

public class Card {

    private int value;
    private String cardDetails;
    private String cardIcon;

    private Rule rule;
    private Suit suit;
    private Rank rank;

    Card() {
    }

    Card(Suit suit, Rank rank) {
        this.rank = rank;
        this.suit = suit;
    }

    Rank getRank() {
        return this.rank;
    }

    public void setRank(Rank newRank) {
        this.rank = newRank;
    }

    int getValue(Rank rank) {
        rule = new Rule(rank.toString());
        return rule.getValueFromRank(rank.toString());
    }

    public void setValue(int newValue) {
        this.value = newValue;
    }

    Suit getSuit() {
        return this.suit;
    }

    public void getSuit(Suit newSuit) {
        this.suit = newSuit;
    }

    String getCardIcon(String cardDetails) {
        switch (cardDetails) {
            // Spades
            case "ACE of SPADES":
                cardIcon = "ace_of_spades";
                break;
            case "TWO of SPADES":
                cardIcon = "two_of_spades";
                break;
            case "THREE of SPADES":
                cardIcon = "three_of_spades";
                break;
            case "FOUR of SPADES":
                cardIcon = "four_of_spades";
                break;
            case "FIVE of SPADES":
                cardIcon = "five_of_spades";
                break;
            case "SIX of SPADES":
                cardIcon = "six_of_spades";
                break;
            case "SEVEN of SPADES":
                cardIcon = "seven_of_spades";
                break;
            case "EIGHT of SPADES":
                cardIcon = "eight_of_spades";
                break;
            case "NINE of SPADES":
                cardIcon = "nine_of_spades";
                break;
            case "TEN of SPADES":
                cardIcon = "ten_of_spades";
                break;
            case "JACK of SPADES":
                cardIcon = "jack_of_spades";
                break;
            case "QUEEN of SPADES":
                cardIcon = "queen_of_spades";
                break;
            case "KING of SPADES":
                cardIcon = "king_of_spades";
                break;
            // Clubs
            case "ACE of CLUBS":
                cardIcon = "ace_of_clubs";
                break;
            case "TWO of CLUBS":
                cardIcon = "two_of_clubs";
                break;
            case "THREE of CLUBS":
                cardIcon = "three_of_clubs";
                break;
            case "FOUR of CLUBS":
                cardIcon = "four_of_clubs";
                break;
            case "FIVE of CLUBS":
                cardIcon = "five_of_clubs";
                break;
            case "SIX of CLUBS":
                cardIcon = "six_of_clubs";
                break;
            case "SEVEN of CLUBS":
                cardIcon = "seven_of_clubs";
                break;
            case "EIGHT of CLUBS":
                cardIcon = "eight_of_clubs";
                break;
            case "NINE of CLUBS":
                cardIcon = "nine_of_clubs";
                break;
            case "TEN of CLUBS":
                cardIcon = "ten_of_clubs";
                break;
            case "JACK of CLUBS":
                cardIcon = "jack_of_clubs";
                break;
            case "QUEEN of CLUBS":
                cardIcon = "queen_of_clubs";
                break;
            case "KING of CLUBS":
                cardIcon = "king_of_clubs";
                break;
            // Hearts
            case "ACE of HEARTS":
                cardIcon = "ace_of_hearts";
                break;
            case "TWO of HEARTS":
                cardIcon = "two_of_hearts";
                break;
            case "THREE of HEARTS":
                cardIcon = "three_of_hearts";
                break;
            case "FOUR of HEARTS":
                cardIcon = "four_of_hearts";
                break;
            case "FIVE of HEARTS":
                cardIcon = "five_of_hearts";
                break;
            case "SIX of HEARTS":
                cardIcon = "six_of_hearts";
                break;
            case "SEVEN of HEARTS":
                cardIcon = "seven_of_hearts";
                break;
            case "EIGHT of HEARTS":
                cardIcon = "eight_of_hearts";
                break;
            case "NINE of HEARTS":
                cardIcon = "nine_of_hearts";
                break;
            case "TEN of HEARTS":
                cardIcon = "ten_of_hearts";
                break;
            case "JACK of HEARTS":
                cardIcon = "jack_of_hearts";
                break;
            case "QUEEN of HEARTS":
                cardIcon = "queen_of_hearts";
                break;
            case "KING of HEARTS":
                cardIcon = "king_of_hearts";
                break;
            // Diamonds
            case "ACE of DIAMONDS":
                cardIcon = "ace_of_diamonds";
                break;
            case "TWO of DIAMONDS":
                cardIcon = "two_of_diamonds";
                break;
            case "THREE of DIAMONDS":
                cardIcon = "three_of_diamonds";
                break;
            case "FOUR of DIAMONDS":
                cardIcon = "four_of_diamonds";
                break;
            case "FIVE of DIAMONDS":
                cardIcon = "five_of_diamonds";
                break;
            case "SIX of DIAMONDS":
                cardIcon = "six_of_diamonds";
                break;
            case "SEVEN of DIAMONDS":
                cardIcon = "seven_of_diamonds";
                break;
            case "EIGHT of DIAMONDS":
                cardIcon = "eight_of_diamonds";
                break;
            case "NINE of DIAMONDS":
                cardIcon = "nine_of_diamonds";
                break;
            case "TEN of DIAMONDS":
                cardIcon = "ten_of_diamonds";
                break;
            case "JACK of DIAMONDS":
                cardIcon = "jack_of_diamonds";
                break;
            case "QUEEN of DIAMONDS":
                cardIcon = "queen_of_diamonds";
                break;
            case "KING of DIAMONDS":
                cardIcon = "king_of_diamonds";
                break;
        }

        return this.cardIcon;
    }
}
