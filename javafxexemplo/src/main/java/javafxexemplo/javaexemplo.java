package javafxexemplo;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class javaexemplo extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Exemplo JavaFX");

        // Create a label with text "Olá, mundo!"
        Label label = new Label("Olá, mundo!");

        // Create a button with text "Clique aqui!"
        Button button = new Button("Clique aqui!");
        // Set an action event handler for the button
        button.setOnAction(e -> label.setText("Botão clicado!"));

        // Create a vertical box layout (VBox)
        VBox vbox = new VBox(10); // The spacing between elements is set to 10
        vbox.getChildren().addAll(label, button); // Add label and button to the VBox
        vbox.setPrefSize(200, 100); // Set preferred width and height for the VBox
        vbox.setSpacing(10); // Set spacing between VBox children

        // Create a scene with the VBox as its root
        Scene scene = new Scene(vbox);

        // Set the scene for the primary stage (main window)
        primaryStage.setScene(scene);

        // Display the primary stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }
}
