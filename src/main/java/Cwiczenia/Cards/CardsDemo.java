package Cwiczenia.Cards;

import java.util.*;

public class CardsDemo {
    static List<Card> deckOfCards = new ArrayList<>();
    static Stack<Card> playingCards = new Stack<>();
    static Card[] hand = new Card[5];

    static {
        createDeck();
    }

    public static void main(String[] args) {

        //losuje rękę ze Stacka
        dealCards();
        for (Card card : hand) {
            System.out.println(card);
        }

/*
        //wyświetla karty w podanym zakresie i kolorze
        System.out.println();
        printCards(Rank.KING,Suit.SPADES);
*/

        //zwraca najwyższą kartę z przekazanej tablicy
        System.out.println("\n" + Analyzer.displayHigherCard(hand));
        System.out.println("\n" + Analyzer.displayHigherCard(playingCards.pop(),playingCards.pop(),playingCards.pop()));

        //zwraca wartość wskazanej karty
        System.out.println("\n" + playingCards.peek() + ", Card Power: " + playingCards.peek().getCardValue());



    }

    private static void createDeck() {
        for(Suit suit : Suit.values()) {
            for(Rank rank : Rank.values()) {
                deckOfCards.add(new Card(rank,suit));
            }
        }

    }

    private static void dealCards() {
        Collections.shuffle(deckOfCards);   //losowanie kart do ręki przez Stack + Collections.shuffle
        playingCards.addAll(0,deckOfCards);

        for (int i = 0; i < hand.length; i++) {
            hand[i] = playingCards.pop();
        }

/*        Random rnd = new Random();        //losowanie kart do ręki przez random
        int cardPick;

        for (int i = 0; i < hand.length; i++) {
            cardPick = rnd.nextInt(deckOfCards.size());
            hand[i] = deckOfCards.get(cardPick);
            deckOfCards.remove(cardPick);
        }*/
    }

    private static void printCards(Rank topRank, Suit ofSuit) {
        for(Rank rank : Rank.values()) {
            if(rank.getCardPower() > topRank.getCardPower()) {
                break;
            }
            System.out.println(new Card(rank,ofSuit));
        }
    }


}
