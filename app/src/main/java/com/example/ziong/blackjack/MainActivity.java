package com.example.ziong.blackjack;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private  Player player;
    private Player dealer;
    private Deck deck;

    // Statistic variables
    private int wins;
    private int losses;
    private int draws;
    private int blackjacks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void disableDealButton()
    {
        Button dealButton = findViewById(R.id.deal_btn);
        Button hitButton = findViewById(R.id.hit_btn);
        Button stayButton = findViewById(R.id.stay_btn);

        // Disables the Deal button and enables the Hit and Stay buttons
        dealButton.setEnabled(false);
        hitButton.setEnabled(true);
        stayButton.setEnabled(true);
    }

    private void enableDealButton()
    {
        Button dealButton = findViewById(R.id.deal_btn);
        Button hitButton = findViewById(R.id.hit_btn);
        Button stayButton = findViewById(R.id.stay_btn);

        // Disables the Deal button and enables the Hit and Stay buttons
        dealButton.setEnabled(true);
        hitButton.setEnabled(false);
        stayButton.setEnabled(false);
    }

    public void deal(View view)
    {

        player = new Player();
        dealer = new Player();
        deck = new Deck();
        // Generate 3 random cards from the deck
        Card playerCard1 = deck.removeCard();
        Card playerCard2 = deck.removeCard();
        Card dealerCard = deck.removeCard();

        // Adds two of the random cards to the player's hand
        player.hit(playerCard1);
        player.hit(playerCard2);

        // Adds one of the random cards to the dealer's hand
        dealer.hit(dealerCard);
        addPlayerDeckImages();
        addDealerDeckImages();

        // Disables the deal button and enables the hit and stay buttons
        disableDealButton();
    }

    private void addPlayerDeckImages()
    {
        // LinearLayout containing the player's card images
        LinearLayout playerDeck = findViewById(R.id.player_deck);
        playerDeck.removeAllViews();
        for (Card card:player.getHand())
        {
            // The ImageView that will be created dynamically
            ImageView cardImage = new ImageView(this);

            //Create the layout parameters for the ImageView Object
            LinearLayout.LayoutParams imageViewParameters = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
            // Applies the layout parameters to the ImageView
            cardImage.setLayoutParams(imageViewParameters);
            // Set the scale type of the ImageView
            cardImage.setScaleType(ImageView.ScaleType.FIT_XY);
            // Set adjust view bounds to true
            cardImage.setAdjustViewBounds(true);
            // Selects which card's image to use
            cardImage.setImageResource(getDrawableId(card.getName()));

            cardImage.getLayoutParams().height = 400;

            playerDeck.addView(cardImage);
        }
    }

    private void addDealerDeckImages()
    {
        // LinearLayout containing the player's card images
        LinearLayout dealerDeck = findViewById(R.id.dealer_deck);
        dealerDeck.removeAllViews();
        for (Card card:dealer.getHand())
        {
            // The ImageView that will be created dynamically
            ImageView cardImage = new ImageView(this);

            //Create the layout parameters for the ImageView Object
            LinearLayout.LayoutParams imageViewParameters = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
            // Applies the layout parameters to the ImageView
            cardImage.setLayoutParams(imageViewParameters);
            // Set the scale type of the ImageView
            cardImage.setScaleType(ImageView.ScaleType.FIT_XY);
            // Set adjust view bounds to true
            cardImage.setAdjustViewBounds(true);
            // Selects which card's image to use
            cardImage.setImageResource(getDrawableId(card.getName()));

            dealerDeck.addView(cardImage);
        }
    }

    private boolean bust(Player player)
    {
        return player.getHandValue() > 21;
    }
    // Checks if the player won
    private boolean win()
    {
        return player.getHandValue() > dealer.getHandValue();
    }

    // Checks for a draw
    private boolean draw()
    {
        return player.getHandValue() == dealer.getHandValue();
    }

    private boolean lose()
    {
        return player.getHandValue() < dealer.getHandValue();
    }

    private void updateScore(String result)
    {
        switch (result) {
            case "win":
                wins++;
                TextView textview = findViewById(R.id.wins);
                textview.setText(String.valueOf(wins));
                break;
            case "draw": {
                draws++;
                TextView textView = findViewById(R.id.draws);
                textView.setText(String.valueOf(draws));
                break;
            }
            case "lose": {
                losses++;
                TextView textView = findViewById(R.id.losses);
                textView.setText(String.valueOf(losses));
                break;
            }
        }


    }


    public void hit(View view)
    {
        player.hit(deck.removeCard());
        addPlayerDeckImages();

        if (bust(player))
        {
            updateScore("lose");
            // Enables the deal button and disables the hit and stay buttons
            enableDealButton();
        }
        // Prevent the player from busting after getting 21
        else if(player.getHandValue() == 21)
        {
            Button hitButton = findViewById(R.id.hit_btn);
            hitButton.setEnabled(false);
        }
    }

    private void getDealerHand()
    {
        while (dealer.getHandValue() < 17)
        {
            dealer.hit(deck.removeCard());
        }
        addDealerDeckImages();
    }

    public void stay(View view)
    {
        enableDealButton();
        getDealerHand();

        if (bust(dealer) || win())
        {
            updateScore("win");
        }
        else if (draw())
        {
            updateScore("draw");
        }
        else if (lose())
        {
            updateScore("lose");
        }
    }

    private int getDrawableId(String cardName)
    {
        switch(cardName)
        {
            case "Ace of clubs":
                return R.drawable.a_c;
            case "2 of clubs":
                return R.drawable.two_c;
            case "3 of clubs":
                return R.drawable.three_c;
            case "4 of clubs":
                return R.drawable.four_c;
            case "5 of clubs":
                return R.drawable.five_c;
            case "6 of clubs":
                return R.drawable.six_c;
            case "7 of clubs":
                return R.drawable.seven_c;
            case "8 of clubs":
                return R.drawable.eight_c;
            case "9 of clubs":
                return R.drawable.nine_c;
            case "10 of clubs":
                return R.drawable.ten_c;
            case "Jack of clubs":
                return R.drawable.j_c;
            case "Queen of clubs":
                return R.drawable.q_c;
            case "King of clubs":
                return R.drawable.k_c;
            case "Ace of diamonds":
                return R.drawable.a_d;
            case "2 of diamonds":
                return R.drawable.two_d;
            case "3 of diamonds":
                return R.drawable.three_d;
            case "4 of diamonds":
                return R.drawable.four_d;
            case "5 of diamonds":
                return R.drawable.five_d;
            case "6 of diamonds":
                return R.drawable.six_d;
            case "7 of diamonds":
                return R.drawable.seven_d;
            case "8 of diamonds":
                return R.drawable.eight_d;
            case "9 of diamonds":
                return R.drawable.nine_d;
            case "10 of diamonds":
                return R.drawable.ten_d;
            case "Jack of diamonds":
                return R.drawable.j_d;
            case "Queen of diamonds":
                return R.drawable.q_d;
            case "King of diamonds":
                return R.drawable.k_d;
            case "Ace of hearts":
                return R.drawable.a_h;
            case "2 of hearts":
                return R.drawable.two_h;
            case "3 of hearts":
                return R.drawable.three_h;
            case "4 of hearts":
                return R.drawable.four_h;
            case "5 of hearts":
                return R.drawable.five_h;
            case "6 of hearts":
                return R.drawable.six_h;
            case "7 of hearts":
                return R.drawable.seven_h;
            case "8 of hearts":
                return R.drawable.eight_h;
            case "9 of hearts":
                return R.drawable.nine_h;
            case "10 of hearts":
                return R.drawable.ten_h;
            case "Jack of hearts":
                return R.drawable.j_h;
            case "Queen of hearts":
                return R.drawable.q_h;
            case "King of hearts":
                return R.drawable.k_h;
            case "Ace of spades":
                return R.drawable.a_s;
            case "2 of spades":
                return R.drawable.two_s;
            case "3 of spades":
                return R.drawable.three_s;
            case "4 of spades":
                return R.drawable.four_s;
            case "5 of spades":
                return R.drawable.five_s;
            case "6 of spades":
                return R.drawable.six_s;
            case "7 of spades":
                return R.drawable.seven_s;
            case "8 of spades":
                return R.drawable.eight_s;
            case "9 of spades":
                return R.drawable.nine_s;
            case "10 of spades":
                return R.drawable.ten_s;
            case "Jack of spades":
                return R.drawable.j_s;
            case "Queen of spades":
                return R.drawable.q_s;
            case "King of spades":
                return R.drawable.k_s;

        }
        return -1;
    }
}
