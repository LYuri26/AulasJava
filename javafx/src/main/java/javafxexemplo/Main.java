package javafxexemplo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private int count = 0;
    private Label countLabel;

    @Override
    public void start(Stage primaryStage) {
        countLabel = new Label("Contagem: " + count);

        Button countButton = new Button("Incrementar");
        countButton.setOnAction(event -> {
            count++;
            updateCountLabel();
        });

        VBox root = new VBox(10);
        root.getChildren().addAll(countLabel, countButton);
        root.setPrefSize(200, 150);
        root.setStyle("-fx-background-color: lightgray; -fx-padding: 20px;");

        Scene scene = new Scene(root);
        primaryStage.setTitle("Contador JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateCountLabel() {
        countLabel.setText("Contagem: " + count);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
