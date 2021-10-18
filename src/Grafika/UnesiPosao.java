package Grafika;

import Baza.BazaPoslovi;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
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
import Paketi.Posao;

public class UnesiPosao extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(0, 5, 0, 5));
        Text naziv = new Text("Naziv:");
        Text satnica = new Text("Satnica:");
        Text vreme = new Text("Vreme (u danima):");
        Text korisnikId = new Text("Broj radnika:");
        TextField nazivPolje = new TextField();
        TextField satnicaPolje = new TextField();
        TextField vremePolje = new TextField();
        TextField brojKorisnikaPolje = new TextField();

        pane.add(naziv, 0, 1);
        pane.add(nazivPolje, 1, 1);
        pane.add(satnica, 0, 2);
        pane.add(satnicaPolje, 1, 2);
        pane.add(vreme, 0, 3);
        pane.add(vremePolje, 1, 3);
        pane.add(korisnikId, 0, 4);
        pane.add(brojKorisnikaPolje, 1, 4);

        Button dugme1 = new Button("Unesi");
        dugme1.setMaxWidth(220);
        pane.add(dugme1, 0, 6);
        Button dugme2 = new Button("Nazad");
        dugme2.setMaxWidth(220);
        pane.add(dugme2, 1, 6);

        Image image = new Image("file:SLIKA.jpg", 300, 230, false, false);
        ImageView iv = new ImageView();
        iv.setImage(image);
        StackPane pane1 = new StackPane();
        pane1.getChildren().addAll(iv, pane);

        dugme1.setOnAction((ActionEvent event) -> {
            String naziv1 = nazivPolje.getText();
            int satnica1 = Integer.parseInt(satnicaPolje.getText());
            int vreme1 = Integer.parseInt(vremePolje.getText());
            int brojKorisnika = Integer.parseInt(brojKorisnikaPolje.getText());
            BazaPoslovi.insertPosao(new Posao(naziv1, satnica1, vreme1, brojKorisnika));
        });

        dugme2.setOnAction((ActionEvent event) -> {
            Grafika grafika = new Grafika();
            grafika.start(primaryStage);
        });

        Scene scene = new Scene(pane1, 300, 230);
        
        primaryStage.setTitle("Unos:");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
