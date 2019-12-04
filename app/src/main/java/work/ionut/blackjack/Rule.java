package work.ionut.blackjack;

class Rule {

    private String rank;
    private int value;

    Rule()
    { }

    Rule(String rank) {
        this.rank = rank;
    }

    String getRank() {
        return this.rank;
    }

    int getValueFromRank(String rank) {
        switch(rank) {
            case "ACE":
                value = 1;
                break;
            case "TWO":
                value = 2;
                break;
            case "THREE":
                value = 3;
                break;
            case "FOUR":
                value = 4;
                break;
            case "FIVE":
                value = 5;
                break;
            case "SIX":
                value = 6;
                break;
            case "SEVEN":
                value = 7;
                break;
            case "EIGHT":
                value = 8;
                break;
            case "NINE":
                value = 9;
                break;
            case "TEN":
                value = 10;
                break;
            case "JACK":
                value = 10;
                break;
            case "QUEEN":
                value = 10;
                break;
            case "KING":
                value = 10;
                break;
        }
        return value;
    }

    String getResult(int player1HandNewValue, int player2HandNewValue) {
        if (player1HandNewValue > player2HandNewValue) {
            return "Player1";
        } else if (player2HandNewValue > player1HandNewValue) {
            return "Player2";
        } else {
            return "Game Drawn";
        }
    }

}