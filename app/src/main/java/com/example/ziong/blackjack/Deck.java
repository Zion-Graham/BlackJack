package com.example.ziong.blackjack;

import java.util.ArrayList;
import java.util.Random;

/*
 * This class represents a full deck of 52 cards
 */
public class Deck
{

    private ArrayList<Card> deck = new ArrayList<>();

    // When instantiated adds a all 52 cards to the deck ArrayList
    Deck()
    {
        deck.add(new Card("Ace of clubs", 11));
        deck.add(new Card("2 of clubs", 2));
        deck.add(new Card("3 of clubs", 3));
        deck.add(new Card("4 of clubs", 4));
        deck.add(new Card("5 of clubs", 5));
        deck.add(new Card("6 of clubs", 6));
        deck.add(new Card("7 of clubs", 7));
        deck.add(new Card("8 of clubs", 8));
        deck.add(new Card("9 of clubs", 9));
        deck.add(new Card("10 of clubs", 10));
        deck.add(new Card("Jack of clubs", 10));
        deck.add(new Card("Queen of clubs", 10));
        deck.add(new Card("King of clubs", 10));
        deck.add(new Card("Ace of diamonds", 11));
        deck.add(new Card("2 of diamonds", 2));
        deck.add(new Card("3 of diamonds", 3));
        deck.add(new Card("4 of diamonds", 4));
        deck.add(new Card("5 of diamonds", 5));
        deck.add(new Card("6 of diamonds", 6));
        deck.add(new Card("7 of diamonds", 7));
        deck.add(new Card("8 of diamonds", 8));
        deck.add(new Card("9 of diamonds", 9));
        deck.add(new Card("10 of diamonds", 10));
        deck.add(new Card("Jack of diamonds", 10));
        deck.add(new Card("Queen of diamonds", 10));
        deck.add(new Card("King of diamonds", 10));
        deck.add(new Card("Ace of hearts", 11));
        deck.add(new Card("2 of hearts", 2));
        deck.add(new Card("3 of hearts", 3));
        deck.add(new Card("4 of hearts", 4));
        deck.add(new Card("5 of hearts", 5));
        deck.add(new Card("6 of hearts", 6));
        deck.add(new Card("7 of hearts", 7));
        deck.add(new Card("8 of hearts", 8));
        deck.add(new Card("9 of hearts", 9));
        deck.add(new Card("10 of hearts", 10));
        deck.add(new Card("Jack of hearts", 10));
        deck.add(new Card("Queen of hearts", 10));
        deck.add(new Card("King of hearts", 10));
        deck.add(new Card("Ace of spades", 11));
        deck.add(new Card("2 of spades", 2));
        deck.add(new Card("3 of spades", 3));
        deck.add(new Card("4 of spades", 4));
        deck.add(new Card("5 of spades", 5));
        deck.add(new Card("6 of spades", 6));
        deck.add(new Card("7 of spades", 7));
        deck.add(new Card("8 of spades", 8));
        deck.add(new Card("9 of spades", 9));
        deck.add(new Card("10 of spades", 10));
        deck.add(new Card("Jack of spades", 10));
        deck.add(new Card("Queen of spades", 10));
        deck.add(new Card("King of spades", 10));
    }

    // Returns a random card from the deck
    public Card removeCard()
    {
        if (!deck.isEmpty())
        {
            int  randomNumber = new Random().nextInt(deck.size());
            return(deck.remove(randomNumber));
        }
        else return null;
    }
}
