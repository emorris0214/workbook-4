package com.pluralsight;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;

    // Default constructor
    public Hand() {
        cards = new ArrayList<>();
    }

    // Overloaded constructor: create hand with 2 starting cards
    public Hand(Card card1, Card card2) {
        cards = new ArrayList<>();
        deal(card1);
        deal(card2);
    }

    // Deal one card
    public void deal(Card card) {
        if (card != null) {
            cards.add(card);
        }
    }

    // Overloaded: deal a list of cards
    public void deal(ArrayList<Card> newCards) {
        for (Card card : newCards) {
            deal(card);
        }
    }

    public int getSize() {
        return cards.size();
    }

    public int getValue() {
        int value = 0;
        int aceCount = 0;

        for (Card card : cards) {
            if (!card.isFaceUp()) card.flip();
            int cardValue = card.getPointValue();
            value += cardValue;

            if (card.getRawValue().equals("A")) aceCount++;
        }

        // Adjust Aces if needed
        while (value > 21 && aceCount > 0) {
            value -= 10;
            aceCount--;
        }

        return value;
    }

    public void showHand() {
        for (Card card : cards) {
            if (!card.isFaceUp()) card.flip();
            System.out.println(card);
        }
    }
}

