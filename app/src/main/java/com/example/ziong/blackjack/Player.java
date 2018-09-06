package com.example.ziong.blackjack;

import java.util.ArrayList;

/*
 * This class represents a Player in BlackJack
 */
public class Player
{
   private Hand playerHand = new Hand();

   // Adds another card to the playerHand ArrayList
   public void hit(Card card)
   {
       playerHand.addCard(card);
   }

   // @Return the int value of the player's hand
   public int getHandValue()
   {
       return playerHand.getValue();
   }

   // @Return the total value of all the cards in the player's hand
   public ArrayList<Card> getHand()
   {
       return playerHand.getCards();
   }

}


