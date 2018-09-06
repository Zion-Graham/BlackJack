package com.example.ziong.blackjack;

import java.util.ArrayList;

public class BlackjackGame
{
    // The player (user playing the game)
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

    /*
     * @Return a string containing win, draw, or nothing indicating
     * the player got 21 and won,
     * the player got 21 and the dealer got 21 resulting in a draw,
     * or the player did not get 21
     */

    public String deal()
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

        if(player.getHandValue() == 21)
        {
            blackjacks ++;
            finishDealerHand();
            if (win())
            {
                wins ++;
                return "win";
            }
            else if (draw())
            {
                draws ++;
                return "draw";
            }
        }
        return "";
    }

    /*
     * @Return if the player loses due to going over 21 or the player gets exactly 21
     */
    public String hit()
    {
        player.hit(deck.removeCard());

        if (bust(player))
        {
            losses ++;
            return "lose";
        }
        else if(player.getHandValue() == 21)
        {
            return "21";
        }

        else
        {
            return "";
        }
    }

    public String stay()
    {
        finishDealerHand();
        getDealerHand();

        if (win())
        {
            wins ++;
            return ("win");
        }
        else if (draw())
        {
            draws ++;
            return ("draw");
        }
        else
        {
            losses ++;
            return ("lose");
        }
    }

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

    /*----------------------------------------------------------------------------------------------
     * Getter Methods
     *--------------------------------------------------------------------------------------------*/

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
