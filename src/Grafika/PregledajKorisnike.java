package Grafika;

import Baza.BazaKorisnik;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import Paketi.Korisnik;

public class PregledajKorisnike extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setAlignment(Pos.CENTER);
        
        TextArea tekst = new TextArea();
        pane.add(tekst, 0, 1);
        
        for(Korisnik korisnik : BazaKorisnik.procitaj()) {
            tekst.appendText(korisnik + "\n");
        }
        
        Button button = new Button("Nazad");
        button.setMinWidth(220);
        GridPane grid = new GridPane();
        grid.add(button, 0, 0);
        grid.setAlignment(Pos.CENTER);
        pane.add(grid, 0, 3);
        
        Image image = new Image("file:SLIKA.jpg", 500, 500, false, false);
        ImageView iv = new ImageView();
        iv.setImage(image);
        StackPane pane1 = new StackPane();
        pane1.getChildren().addAll(iv, pane);
        
        button.setOnAction((ActionEvent event) -> {
            Grafika grafika = new Grafika();
            grafika.start(primaryStage);
        });
        
        Scene scene = new Scene(pane1, 500, 500);
        
        primaryStage.setTitle("Pregledanje:");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
