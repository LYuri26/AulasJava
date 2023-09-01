package javafxexemplo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SovietFlagGenerator extends Application {

    private static final String[] FLAG_URLS = {
            "https://img.elo7.com.br/product/original/2CFD388/adesivo-bandeira-uniao-sovietica-sovietico-ww2-frete-gratis-segunda-guerra-mundial.jpg",
            "https://media.istockphoto.com/id/629481780/pt/vetorial/soviet-union-flag-concept.jpg?s=612x612&w=0&k=20&c=I3bUGYiF7E52idh5iUqH8QK2HtUdukQ6Kwv_SIT5uhE=",
            "https://farm5.staticflickr.com/4454/37899680182_3ccafa361f_o.jpg",
            "https://img.freepik.com/fotos-premium/bandeira-da-uniao-sovietica-com-grandes-dobras-acenando-sob-a-luz-do-estudio-dentro-de-casa-os-simbolos-oficiais-e-cores-no-banner_76080-16123.jpg",
            "https://aulazen.com/wp-content/uploads/2018/06/1-3.jpg"
            // Adicione mais URLs de imagens da bandeira soviética conforme necessário
    };

    private int currentImageIndex = 0;
    private ImageView imageView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Bandeira da União Soviética");

        BorderPane root = new BorderPane();

        // Configura a visualização da imagem
        imageView = new ImageView();
        setImage(currentImageIndex);

        // Configura o botão para mudar a imagem
        Button changeImageButton = new Button("Mudar Imagem");
        changeImageButton.setOnAction(e -> {
            currentImageIndex = (currentImageIndex + 1) % FLAG_URLS.length;
            setImage(currentImageIndex);
        });

        // Define o tamanho padrão das imagens
        imageView.setFitWidth(400);
        imageView.setFitHeight(300);

        // Posicione o botão na parte inferior
        BorderPane.setAlignment(changeImageButton, Pos.CENTER);
        root.setBottom(changeImageButton);

        root.setCenter(imageView);

        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    private void setImage(int index) {
        Image image = new Image(FLAG_URLS[index]);
        imageView.setImage(image);
    }
}
