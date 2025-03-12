
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GamePage extends Application {

  public void start(Stage PrimaryStage) {
    BorderPane root = new BorderPane();
    root.setStyle("-fx-background-color: #F0EFEB;");

    Scene scene = new Scene(root, 800, 600);
    scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

    PrimaryStage.setTitle("Card Game");
    PrimaryStage.setScene(scene);
    PrimaryStage.show();
  }
}