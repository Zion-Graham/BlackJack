package com.example.ziong.blackjack;

import java.util.ArrayList;

/*
 * This class represents the hand of the player
 * Cards can be added through the addCard method
 * The value of the Hand is returned through the getValue method
 */

public class Hand
{
    private ArrayList<Card> handDeck = new ArrayList<>();

    public void addCard(Card card)
    {
        handDeck.add(card);
    }
    /*
     * Returns the total value of a Hand of cards
     * If the hand contains aces, this method will return the highest value less than 22
     * i.e. if there are 2 aces in a hand with potential values of 2, 12, or 22 it will return 12
     */
    public int getValue()
    {
        // Total value of the cards in the Hand
        int value = 0;

        // Number of aces in the Hand
        int numAce = 0;

        /*
         * Calculates the value of the deck assuming aces are equal to 11
         * Stores the number of aces into numAce
         */
        for (int x = 0; x < handDeck.size(); x++)
        {
            // Adds the value of the card to the total Hand value
            value += handDeck.get(x).getValue();

            // If the card's name contains the word Ace, increment numAce
            if (handDeck.get(x).getName().contains("Ace"))
            {
                numAce += 1;
            }
        }

        // Recalculates the value of a Hand if its value is over 21 and it has at least 1 ace card
        if (value > 21 && numAce > 0)
        {
            // Highest allowed value for a valid Hand (less than 22)
            int maxValue = 0;

            // A temporary value representing the total value of a Hand
            int tempValue = value;

            // For each ace, calculate the Hand value if its value is "set" to 1
            for (int x = 0; x < numAce; x++)
            {
                /*
                 * If maxValue is less than tempValue - 10 (representing changing one of the ace card's value to 1)
                 * If the new tempValue is valid (less than 22), set the max value to tempValue
                 */
                if (maxValue < tempValue && tempValue - 10 < 22)
                {
                    maxValue = tempValue - 10;
                }
                // Decrement tempValue by 10 to represent the Ace's value being set to 1
                tempValue -= 10;
            }
            // If there was a valid maxValue, make value equal to maxValue
            if (maxValue > 0) {
                value = maxValue;
            }
        }
        // Return the total value of the Hand
        return value;
    }

    public static void main(String args[])
    {
        Hand myHand = new Hand();
        myHand.addCard(new Card("Ace of clubs", 11));
        myHand.addCard(new Card("King of hearts", 10));
        myHand.addCard(new Card("5 of hearts", 5));
        System.out.println(myHand.getValue());
    }
}
