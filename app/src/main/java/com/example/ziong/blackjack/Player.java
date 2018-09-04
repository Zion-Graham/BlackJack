package com.example.ziong.blackjack;

import java.util.ArrayList;

/*
 * This class represents the Player in BlackJack
 * Each Player is able to do one of 5 actions Deal, Hit, Stay, Double, Split
 * Each player has a "hand", a deck of cards in his/her hand
 */
public class Player
{
   private Hand playerHand = new Hand();

   public void hit(Card card)
   {
       playerHand.addCard(card);
   }

   // Prints the value of the player's hand
   public int getHandValue()
   {
       return playerHand.getValue();
   }

   public ArrayList<Card> getHand()
   {
       return playerHand.getCards();
   }

}


