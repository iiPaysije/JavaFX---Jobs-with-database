package Grafika;

import Baza.BazaPoslovi;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ObrisiPosao extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(20);
        pane.setAlignment(Pos.CENTER);
        Text indeks = new Text("ID posla: ");
        TextField indeksPolje = new TextField();
        pane.add(indeks, 0, 1);
        pane.add(indeksPolje, 1, 1);
        Button dugme1 = new Button("Obrisi");
        dugme1.setMaxWidth(220);
        Button dugme2 = new Button("Nazad");
        dugme2.setMaxWidth(220);
        pane.add(dugme1, 0, 2);
        pane.add(dugme2, 1, 2);
        
        
        
        Image image = new Image("file:SLIKA.jpg", 300, 250, false, false);
        ImageView iv = new ImageView();
        iv.setImage(image);
        StackPane pane1 = new StackPane();
        pane1.getChildren().addAll(iv, pane);
        
        dugme1.setOnAction((ActionEvent event) -> {
            int indeks1 = Integer.parseInt(indeksPolje.getText());
            BazaPoslovi.obrisiPosao(indeks1);
            indeksPolje.appendText("");
        });
        
        dugme2.setOnAction((ActionEvent event) -> {
            Grafika grafika = new Grafika();
            grafika.start(primaryStage);
        });
        
        Scene scene = new Scene(pane1, 300, 250);
        
        primaryStage.setTitle("Brisanje:");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
