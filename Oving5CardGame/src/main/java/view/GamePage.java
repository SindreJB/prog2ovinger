package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Card;
import model.DeckOfCards;
import model.Suit;

import java.util.ArrayList;
import java.util.List;

public class GamePage extends Application {

  private DeckOfCards deck;
  private List<Card> currentHand = new ArrayList<>();
  private FlowPane cardsContainer;
  private Label statusLabel;
  private Label flushLabel;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    // Initialize the deck
    deck = new DeckOfCards();

    // Create the main layout
    BorderPane root = new BorderPane();
    root.setStyle("-fx-background-color: #F0EFEB;");
    root.setPadding(new Insets(20));

    // Create title
    Label titleLabel = new Label("Card Game");
    titleLabel.getStyleClass().add("game-title");

    // Create buttons for game actions
    Button dealButton = new Button("Deal New Hand");
    dealButton.setOnAction(e -> dealNewHand());

    Button dealUntilFlushButton = new Button("Deal Until Flush");
    dealUntilFlushButton.setOnAction(e -> dealUntilFlush());

    // Create status label
    statusLabel = new Label("Welcome to Card Game! Press 'Deal New Hand' to start.");
    flushLabel = new Label("You got a FLUSH!");
    flushLabel.getStyleClass().add("flush-label");
    flushLabel.setVisible(false);

    // Create container for cards
    cardsContainer = new FlowPane();
    cardsContainer.setHgap(10);
    cardsContainer.setVgap(10);
    cardsContainer.setPadding(new Insets(20));
    cardsContainer.setAlignment(Pos.CENTER);

    // Create top controls
    HBox topControls = new HBox(10);
    topControls.setAlignment(Pos.CENTER);
    topControls.getChildren().addAll(titleLabel);

    // Create bottom controls
    HBox bottomControls = new HBox(10);
    bottomControls.setAlignment(Pos.CENTER);
    bottomControls.setPadding(new Insets(10));
    bottomControls.getChildren().addAll(dealButton, dealUntilFlushButton);

    // Add all components to the root layout
    StackPane centerPane = new StackPane(cardsContainer, flushLabel);
    root.setTop(topControls);
    root.setCenter(centerPane);
    root.setBottom(new VBox(10, statusLabel, bottomControls));

    // Create the scene
    Scene scene = new Scene(root, 800, 600);
    scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

    // Configure the stage
    primaryStage.setTitle("Card Game");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private void dealNewHand() {
    // Clear existing cards
    cardsContainer.getChildren().clear();
    flushLabel.setVisible(false);

    // Create a new deck if needed
    if (deck.getDeckOfCards().size() < 5) {
      deck = new DeckOfCards();
      statusLabel.setText("Deck reshuffled.");
    }

    // Deal 5 cards
    currentHand = deck.dealHand(5);

    // Update the cards display (visual representation)
    for (Card card : currentHand) {
      StackPane cardPane = createCardView(card);
      cardsContainer.getChildren().add(cardPane);
    }

    // Check for flush
    if (isFlush(currentHand)) {
      flushLabel.setVisible(true);
      statusLabel.setText("You got a FLUSH! New hand dealt. " + deck.getDeckOfCards().size() + " cards remaining in deck.");
    } else {
      statusLabel.setText("New hand dealt. " + deck.getDeckOfCards().size() + " cards remaining in deck.");
    }
  }

  private void dealUntilFlush() {
    int handsDealt = 0;
    boolean flushFound = false;

    while (!flushFound) {
      handsDealt++;
      dealNewHand();
      flushFound = isFlush(currentHand);
    }

    flushLabel.setVisible(true);
    statusLabel.setText("You got a FLUSH after " + handsDealt + " hands! " + deck.getDeckOfCards().size() + " cards remaining in deck.");
  }

  private boolean isFlush(List<Card> hand) {
    if (hand.isEmpty()) return false;
    Suit firstSuit = hand.get(0).getSuit();
    for (Card card : hand) {
      if (card.getSuit() != firstSuit) {
        return false;
      }
    }
    return true;
  }

  private StackPane createCardView(Card card) {
    // Create a visual representation of a card
    StackPane cardPane = new StackPane();
    cardPane.setPrefSize(120, 180);
    cardPane.getStyleClass().add("card");

    VBox cardContent = new VBox(5);
    cardContent.setAlignment(Pos.CENTER);

    String suitSymbol = getSuitSymbol(card.getSuit());
    String color = (card.getSuit() == Suit.HEARTS || card.getSuit() == Suit.DIAMONDS) ? "card-red" : "card-black";

    Label rankLabel = new Label(card.getRank().getName());
    rankLabel.getStyleClass().add(color);

    Label suitLabel = new Label(suitSymbol);
    suitLabel.getStyleClass().add(color);
    suitLabel.setStyle("-fx-font-size: 40px;");

    cardContent.getChildren().addAll(rankLabel, suitLabel);
    cardPane.getChildren().add(cardContent);

    return cardPane;
  }

  private String getSuitSymbol(Suit suit) {
    switch (suit) {
      case HEARTS: return "♥";
      case DIAMONDS: return "♦";
      case CLUBS: return "♣";
      case SPADES: return "♠";
      default: return "";
    }
  }
}