package com.example.ziong.blackjack;
/*
 * This class represents each individual card in a standard deck of cards
 * Each card has a name and numerical value associated with it
 */
public class Card
{
    private String name;
    private int value;

    Card(String name, int value)
    {
        this.name = name;
        this.value = value;
    }

    // @Return the name of the card
    public String getName()
    {
        return name;
    }

    // @Return the int value of the card
    public int getValue()
    {
        return value;
    }
}
