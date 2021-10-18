package Grafika;

import Grafika.Pracenje;
import Grafika.PokreniPosao;
import Grafika.Grafika;
import Baza.BazaPoslovi;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Paketi.Posao;

public class PregledajPoId extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setAlignment(Pos.CENTER);

        Text Naslov = new Text("U donjem polju unesite ID posla na kome zelite raditi");
        TextArea tekst = new TextArea();
        pane.add(Naslov, 0, 1);
        pane.add(tekst, 0, 2);

        for (Posao posao : BazaPoslovi.procitajPosloveId(PokreniPosao.id)) {
            tekst.appendText(posao + "\n");
        }

        Button button = new Button("Nazad");
        Button button1 = new Button("Unesi");

        TextField polje = new TextField();
        Text unosenje = new Text("ID posla na kome zelite poceti rad");

        pane.add(unosenje, 0, 3);
        pane.add(polje, 0, 4);
        pane.add(button1, 0, 5);
        pane.add(button, 0, 6);

        Image image = new Image("file:SLIKA.jpg", 500, 500, false, false);
        ImageView iv = new ImageView();
        iv.setImage(image);
        StackPane pane1 = new StackPane();
        pane1.getChildren().addAll(iv, pane);

        button1.setOnAction((ActionEvent event) -> {
            int id = Integer.parseInt(polje.getText());
            Pracenje pracenje = new Pracenje();
            try {
                pracenje.start(primaryStage);
            } catch (Exception ex) {
                Logger.getLogger(PregledajPoId.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        button.setOnAction((ActionEvent event) -> {
            Grafika grafika = new Grafika();
            grafika.start(primaryStage);
        });

        Scene scene = new Scene(pane1, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
