import model.DeckOfCards;

public class App {

  public static void main(String[] args) {
    DeckOfCards deck = new DeckOfCards();
    deck.dealHand(5);
    System.out.println(" ");
    System.out.println("Remaining cards in the deck:");
    deck.printDeck();
  }
}
