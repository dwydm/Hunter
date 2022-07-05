package Cwiczenia.Cards;

public class Card {
    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getCardValue() {
        return rank.getCardPower();
    }

    @Override
    public String toString() {
        return rank.getName() + " of " + suit.getName();
    }
}
