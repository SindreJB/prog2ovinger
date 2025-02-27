package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DeckOfCards {

  private HashMap<Integer, Card> deckOfCards;

  public DeckOfCards() {
    deckOfCards = Stream.of(Suit.values())
        .flatMap(suit -> Stream.of(Rank.values())
            .map(rank -> new Card(rank, suit)))
        .collect(Collectors.toMap(Object::hashCode, card -> card, (e1, e2) -> e1, HashMap::new));
  }

  public HashMap<Integer, Card> getDeckOfCards() {
    return deckOfCards;
  }

  public void setDeckOfCards(HashMap<Integer, Card> deckOfCards) {
    this.deckOfCards = deckOfCards;
  }

  public void printDeck() {
    deckOfCards.values().stream()
        .sorted(Comparator.comparing(Card::getSuit).thenComparing(Card::getRank))
        .forEach(card -> System.out.println(card.getRank().getName() + " of " + card.getSuit().name()));
  }


  public void dealHand(int numberOfCards) {
    List<Card> cardsToDeal = new ArrayList<>(deckOfCards.values());

    Collections.shuffle(cardsToDeal);

    cardsToDeal.stream()
      .limit(numberOfCards)
      .forEach(card -> {
        System.out.println(card.getRank().getName() + " of " + card.getSuit().name());
        deckOfCards.remove(card.hashCode());
      });
  }
}