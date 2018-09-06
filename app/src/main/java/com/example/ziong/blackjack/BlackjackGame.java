package com.example.ziong.blackjack;

import java.util.ArrayList;

/*
 * This class represents the flow of a blackjack game implementing Deal(), Hit(), and Stay()
 */
public class BlackjackGame
{
    // The player (user)
    private  Player player;

    // The dealer
    private Player dealer;

    // The full deck of cards
    private Deck deck;

    // Score variables for each game
    private static int wins = 0;
    private static int losses = 0;
    private static int draws = 0;
    private static int blackjacks = 0;

/*------------------------------------------------------------------------------------------------
   Public Methods
*-------------------------------------------------------------------------------------------------*/

    /*
     * @Return a String containing win, draw, or "" indicating
     * the player got 21 and won,
     * the player and dealer got 21 resulting in a draw,
     * or the player did not get 21
     */
    public String deal()
    {
        // Create a new instance of player, dealer, and deck
        player = new Player();
        dealer = new Player();
        deck = new Deck();

        // Generate 3 random cards from the deck
        Card playerCard1 = deck.removeCard();
        Card playerCard2 = deck.removeCard();
        Card dealerCard = deck.removeCard();

        // Add two of the random cards to the player's hand
        player.hit(playerCard1);
        player.hit(playerCard2);

        // Adds one of the random cards to the dealer's hand
        dealer.hit(dealerCard);

        // If the player gets blackjack
        if(player.getHandValue() == 21)
        {
            // Add 1 to the total number of blackjacks
            blackjacks ++;

            // Have the dealer finish its hand
            finishDealerHand();

            // If the player's hand is greater than the dealer's, add 1 to the total number of wins and return "win"
            if (win())
            {
                wins ++;
                return "win";
            }
            // Else if the player's hand is equal to the dealer's, add 1 to the total number of draws and return "draw"
            else if (draw())
            {
                draws ++;
                return "draw";
            }
        }
        // If the player didn't get blackjack, return the empty string
        return "";
    }

    /*
     * Adds a card to the player's deck
     * @Return a String indicating if the player loses due to going over 21, or the player gets exactly 21
     */
    public String hit()
    {
        // Adds card to the player's deck
        player.hit(deck.removeCard());

        // If the player's hand goes over 21, add 1 to losses and return "lose"
        if (bust(player))
        {
            losses ++;
            return "lose";
        }
        // Else if the player's hand is equal to 21 return "21"
        else if(player.getHandValue() == 21)
        {
            return "21";
        }
        // Else return the empty string
        else
        {
            return "";
        }
    }

    /*
     * @Return a string indicating if the player wins, loses, or gets a draw
     */
    public String stay()
    {
        // Has the dealer hit until its hand is > 16
        finishDealerHand();

        // If the dealer busts or the player deck is greater than the dealer's add 1 to win and return "win"
        if (win())
        {
            wins ++;
            return ("win");
        }

        // Else if the dealer and player's hands are equal, add 1 to draws and return "draw"
        else if (draw())
        {
            draws ++;
            return ("draw");
        }

        // Else if the dealer's hand is greater than the player's add 1 to losses and return "lose"
        else
        {
            losses ++;
            return ("lose");
        }
    }

/*------------------------------------------------------------------------------------------------
   Private Methods
*-------------------------------------------------------------------------------------------------*/
    // Checks if the player's hand is over 21
    private boolean bust(Player player)
    {
        return player.getHandValue() > 21;
    }
    // Checks if the player's hand is greater than the dealers
    private boolean win()
    {
        return player.getHandValue() > dealer.getHandValue() || bust(dealer);
    }

    // Checks if the player and dealer's hands are equal
    private boolean draw()
    {
        return player.getHandValue() == dealer.getHandValue();
    }

    // Checks if the player's hand is less than the dealers
    private boolean lose()
    {
        return player.getHandValue() < dealer.getHandValue();
    }

    private void finishDealerHand()
    {
        while (dealer.getHandValue() < 17)
        {
            dealer.hit(deck.removeCard());
        }
    }

/*------------------------------------------------------------------------------------------------
   Getter Methods
*-------------------------------------------------------------------------------------------------*/

    public ArrayList<Card> getPlayerHand()
    {
        return player.getHand();
    }

    public ArrayList<Card> getDealerHand()
    {
        return dealer.getHand();
    }

    public static String getWins() {
        return String.valueOf(wins);
    }

    public String getLosses()
    {
        return String.valueOf(losses);
    }

    public String getDraws()
    {
        return String.valueOf(draws);
    }

    public String getBlackjacks()
    {
        return String.valueOf(blackjacks);
    }
}
