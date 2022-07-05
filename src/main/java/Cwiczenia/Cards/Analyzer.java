package Cwiczenia.Cards;

public class Analyzer {

    public static Card displayHigherCard(Card... cards) {
        Card topCard = cards[0];
        for (Card card : cards) {
            if (card.getCardValue() == 1) {
                topCard = card;
                break;
            }
            else if(topCard.getCardValue() < card.getCardValue()) {
                topCard = card;
            }
        }
        return topCard;
    }
}
