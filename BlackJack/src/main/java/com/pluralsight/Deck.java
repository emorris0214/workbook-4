package com.pluralsight;

import java.util.ArrayList;
import java.util.Collections;

import java.util.*;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        String[] suits = {"Hearts", "Spades", "Diamonds", "Clubs"};
        String[] values = {"2", "3", "4", "5", "6", "7", "8",
                "9", "10", "J", "Q", "K", "A"};

        for (String suit : suits) {
            for (String value : values) {
                cards.add(new Card(suit, value));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Deals one card
    public Card deal() {
        if (cards.isEmpty()) return null;
        Card card = cards.remove(0);
        card.flip();
        return card;
    }

    // Overloaded method: deal multiple cards at once
    public ArrayList<Card> deal(int count) {
        ArrayList<Card> hand = new ArrayList<>();
        for (int i = 0; i < count && !cards.isEmpty(); i++) {
            hand.add(deal());
        }
        return hand;
    }

    public int getSize() {
        return cards.size();
    }
}

