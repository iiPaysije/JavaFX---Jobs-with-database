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

public class IzmeniPoslove extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(0, 10, 0, 10));
        Text id = new Text("ID: ");
        TextField idPolje = new TextField();
        Text naziv = new Text("Naziv: ");
        TextField nazivPolje = new TextField();
        Text satnica = new Text("Satnica: ");
        TextField satnicaPolje = new TextField();
        Text vreme = new Text("Vreme(u danima): ");
        TextField vremePolje = new TextField();
        Text brojKorisnika = new Text("Broj radnika: ");
        TextField brojKorisnikaPolje = new TextField();
        
        pane.add(id, 0, 1);
        pane.add(idPolje, 1, 1);
        pane.add(naziv, 0, 2);
        pane.add(nazivPolje, 1, 2);
        pane.add(satnica, 0, 3);
        pane.add(satnicaPolje, 1, 3);
        pane.add(vreme, 0, 4);
        pane.add(vremePolje, 1, 4);
        pane.add(brojKorisnika, 0, 5);
        pane.add(brojKorisnikaPolje, 1, 5);
        
        Button dugme1 = new Button("Izmeni");
        dugme1.setMaxWidth(250);
        Button dugme2 = new Button("Nazad");
        dugme2.setMaxWidth(250);
        
        pane.add(dugme1, 0, 7);
        pane.add(dugme2, 1, 7);
        
        Image image = new Image("file:SLIKA.jpg", 300, 300, false, false);
        ImageView iv = new ImageView();
        iv.setImage(image);
        StackPane pane1 = new StackPane();
        pane1.getChildren().addAll(iv, pane);
        
        
        dugme1.setOnAction((ActionEvent event) -> {
            int id1 = Integer.parseInt(idPolje.getText());
            String naziv1 = nazivPolje.getText();
            int satnica1 = Integer.parseInt(satnicaPolje.getText());
            int vreme1 = Integer.parseInt(vremePolje.getText());
            int brojKorisnika1 = Integer.parseInt(brojKorisnikaPolje.getText());
            BazaPoslovi.updatePosao(id1, new Posao(naziv1, satnica1, vreme1, brojKorisnika1));
        });
        
        dugme2.setOnAction((ActionEvent event) -> {
            Grafika grafika = new Grafika();
            grafika.start(primaryStage);
        });
        
        Scene scene = new Scene(pane1, 300,300);
        
        primaryStage.setTitle("Izmeni:");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
