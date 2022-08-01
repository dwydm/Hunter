package Cwiczenia.Cards;

import Cwiczenia.Cards.Deck.Card;
import Cwiczenia.Workshop.Car;

import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> hand;
    private int chips = 1000;
    private boolean isActive;

    public Player(String name) {
        this.name = name;
    }



    public void setHand(Card... cards) {
        hand.add(cards[0]);

        if(cards.length == 1) {
            return;
        }

        for (int i = 1; i < cards.length; i++) {
            addCardToHand(cards[i]);
        }
    }

    public Card replaceCard(int index, Card card) {
        Card replacedCard = hand.get(index);
        hand.set(index-1,card);
        return replacedCard;
    }

    public Card[] returnAllCards() {
        Card[] returnedHand = hand.toArray(new Card[hand.size()]);
        hand.clear();
        return returnedHand;
    }

    public void addCardToHand(Card card) {
        for (int i = 0; i < hand.size(); i++) {
            if(card.getCardValue() < hand.get(i).getCardValue()) {
                hand.add(i,card);
                return;
            }
        }
        hand.add(card);
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
