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

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
