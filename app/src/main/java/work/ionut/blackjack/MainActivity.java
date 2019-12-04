package work.ionut.blackjack;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Deck deck = new Deck();

    Hand hand1 = new Hand(deck);
    Hand hand2 = new Hand(deck);

    Player player1 = new Player("Player1", hand1);
    Player player2 = new Player("Player2", hand2);

    Game game = new Game(player1, player2);

    private ArrayList<Card> player1Hand;
    private ArrayList<Card> player2Hand;

    Button buttonPlayer1;
    Button buttonPlayer2;

    Button stopPlayer1Button;
    Button stopPlayer2Button;
    Button resetButton;

    TextView textResultPlayer1;
    TextView textResultPlayer2;

    TextView ScorePlayer1;
    TextView ScorePlayer2;

    boolean stopPlayer1 = false;
    boolean stopPlayer2 = false;

    int score1 = 0;
    int score2 = 0;

    private ArrayList<ImageView> player1Deck = new ArrayList<>(10);
    private ArrayList<ImageView> player2Deck = new ArrayList<>(10);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPlayer1 = findViewById(R.id.buttonPlayer1);

        player1Deck.add((ImageView)findViewById(R.id.player1Card10Image));
        player1Deck.add((ImageView)findViewById(R.id.player1Card9Image));
        player1Deck.add((ImageView)findViewById(R.id.player1Card8Image));
        player1Deck.add((ImageView)findViewById(R.id.player1Card7Image));
        player1Deck.add((ImageView)findViewById(R.id.player1Card6Image));
        player1Deck.add((ImageView)findViewById(R.id.player1Card5Image));
        player1Deck.add((ImageView)findViewById(R.id.player1Card4Image));
        player1Deck.add((ImageView)findViewById(R.id.player1Card3Image));
        player1Deck.add((ImageView)findViewById(R.id.player1Card2Image));
        player1Deck.add((ImageView)findViewById(R.id.player1Card1Image));

        buttonPlayer2 = findViewById(R.id.buttonPlayer2);
        buttonPlayer2.setEnabled(false);

        player2Deck.add((ImageView)findViewById(R.id.player2Card1Image));
        player2Deck.add((ImageView)findViewById(R.id.player2Card2Image));
        player2Deck.add((ImageView)findViewById(R.id.player2Card3Image));
        player2Deck.add((ImageView)findViewById(R.id.player2Card4Image));
        player2Deck.add((ImageView)findViewById(R.id.player2Card5Image));
        player2Deck.add((ImageView)findViewById(R.id.player2Card6Image));
        player2Deck.add((ImageView)findViewById(R.id.player2Card7Image));
        player2Deck.add((ImageView)findViewById(R.id.player2Card8Image));
        player2Deck.add((ImageView)findViewById(R.id.player2Card9Image));
        player2Deck.add((ImageView)findViewById(R.id.player2Card10Image));

        textResultPlayer1 = findViewById(R.id.gameResultPlayer1);
        textResultPlayer2 = findViewById(R.id.gameResultPlayer2);

        ScorePlayer1 = findViewById(R.id.ScorePlayer1);
        ScorePlayer2 = findViewById(R.id.ScorePlayer2);

        stopPlayer1Button = findViewById(R.id.stopPlayer1);
        stopPlayer2Button = findViewById(R.id.stopPlayer2);
        resetButton = findViewById(R.id.buttonReset);
        resetButton.setVisibility(View.GONE);

        stopPlayer1Button.setVisibility(View.GONE);
        stopPlayer2Button.setVisibility(View.GONE);

        stopPlayer1Button.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
        stopPlayer2Button.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
    }

    public void onResetButtonClick(View view) {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    public void onPlayer1Stop(View view) {
        stopPlayer1 = true;

        buttonPlayer1.setVisibility(View.GONE);
        stopPlayer1Button.setVisibility(View.GONE);
        buttonPlayer2.setEnabled(true);
        stopPlayer2Button.setEnabled(true);

        if(stopPlayer2)
            endGame();
    }

    public void onPlayer2Stop(View view) {
        stopPlayer2 = true;

        buttonPlayer2.setVisibility(View.GONE);
        stopPlayer2Button.setVisibility(View.GONE);
        buttonPlayer1.setEnabled(true);
        stopPlayer1Button.setEnabled(true);

        if(stopPlayer1)
            endGame();
    }

    public void onPlayer1ButtonClick(View view) {
        if(!stopPlayer2) {
            buttonPlayer1.setEnabled(false);
            stopPlayer1Button.setEnabled(false);
            buttonPlayer2.setEnabled(true);
            stopPlayer2Button.setEnabled(true);
        }
        ArrayList<ImageView> player1CardIconImageViews = new ArrayList<>();

        if(player1Hand != null && player1Hand.size() == 1)
            stopPlayer1Button.setVisibility(View.VISIBLE);

        for(int i=0;i<=9;i++)
            player1CardIconImageViews.add(player1Deck.get(i));

        int count = 0;
        int count_ace = 0;

        int imageViewIndex = 0;

        if(player1Hand != null && player1Hand.size() == 10) return;

        player1Hand = game.dealPlayer1Card();

        for (Card card:player1Hand) {
            Suit suit = card.getSuit();
            Rank rank = card.getRank();

            int value = card.getValue(rank);

            if(value!=1)
                count+=card.getValue(rank);
            else count_ace++;

            String player1CardDetails = rank + " of " + suit;
            String player1EachIcon = card.getCardIcon(player1CardDetails);

            setCardImage(player1EachIcon, player1CardIconImageViews.get(imageViewIndex));
            imageViewIndex++;
        }

        if(count_ace!=0)
        {
            int check_value = count;
            check_value+=11;
            check_value+=(count_ace-1);

            if(check_value>21)
                count = count + count_ace;
            else count = check_value;
        }
        score1 = count;

        ScorePlayer1.setText(Integer.toString(count));

        if(count>=21)
            endGame();
        else if(stopPlayer2)
        {
            int count_player2 = Integer.parseInt(ScorePlayer2.getText().toString());
            if(count>count_player2)
                endGame();
        }
    }

    public void onPlayer2ButtonClick(View view) {
        if(!stopPlayer1) {
            buttonPlayer2.setEnabled(false);
            stopPlayer2Button.setEnabled(false);
            buttonPlayer1.setEnabled(true);
            stopPlayer1Button.setEnabled(true);
        }

        ArrayList<ImageView> player2CardIconImageViews = new ArrayList<>();

        if(player2Hand != null && player2Hand.size() == 1)
            stopPlayer2Button.setVisibility(View.VISIBLE);

        for(int i=0;i<=9;i++)
            player2CardIconImageViews.add(player2Deck.get(i));

        int count = 0;
        int count_ace = 0;

        int imageViewIndex = 0;

        if(player2Hand != null && player2Hand.size() == 10) return;

        player2Hand = game.dealPlayer2Card();

        for (Card card:player2Hand) {
            Suit suit = card.getSuit();
            Rank rank = card.getRank();

            int value = card.getValue(rank);

            if(value!=1)
                count+=card.getValue(rank);
            else count_ace++;

            String player2CardDetails = rank + " of " + suit;
            String player2EachIcon = card.getCardIcon(player2CardDetails);

            setCardImage(player2EachIcon, player2CardIconImageViews.get(imageViewIndex));
            imageViewIndex++;
        }

        if(count_ace!=0)
        {
            int check_value = count;
            check_value+=11;
            check_value+=(count_ace-1);

            if(check_value>21)
                count = count + count_ace;
            else count = check_value;
        }
        score2 = count;

        ScorePlayer2.setText(Integer.toString(count));

        if(count>=21)
            endGame();
        else if(stopPlayer1)
        {
            int count_player1 = Integer.parseInt(ScorePlayer1.getText().toString());
            if(count>count_player1)
                endGame();
        }
    }

    public void endGame() {
        buttonPlayer1.setVisibility(View.GONE);
        stopPlayer1Button.setVisibility(View.GONE);
        buttonPlayer2.setVisibility(View.GONE);
        stopPlayer2Button.setVisibility(View.GONE);

        resetButton.setVisibility(View.VISIBLE);

        if(score1>21)
            updateStatus(2);
        else if(score2>21)
            updateStatus(1);

        if(score1<=21 && score2<=21) {
            if (score1 > score2)
                updateStatus(1);
            else if (score1 < score2)
                updateStatus(2);
            else
                updateStatus(3);
        }
    }

    public void updateStatus(int result)
    {
        if(result==1) {
            textResultPlayer1.setText("Ai castigat!");
            textResultPlayer1.setTextColor(Color.GREEN);

            textResultPlayer2.setText("Ai pierdut!");
            textResultPlayer2.setTextColor(Color.RED);
        } else if(result==2) {
            textResultPlayer2.setText("Ai castigat!");
            textResultPlayer2.setTextColor(Color.GREEN);

            textResultPlayer1.setText("Ai pierdut!");
            textResultPlayer1.setTextColor(Color.RED);
        } else {
            textResultPlayer2.setText("Egalitate!");
            textResultPlayer2.setTextColor(Color.BLUE);

            textResultPlayer1.setText("Egalitate!");
            textResultPlayer1.setTextColor(Color.BLUE);
        }
    }

    public void setCardImage(String card, ImageView imageView) {
        int imageId = getResources().getIdentifier(card, "drawable", getPackageName());
        imageView.setImageResource(imageId);
    }
}