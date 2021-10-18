package Grafika;

import Baza.BazaKorisnik;
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
import Paketi.Korisnik;

public class IzmeniKorisnike extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(5);
        pane.setVgap(5);
        pane.setPadding(new Insets(0, 5, 0, 5));
        Text id = new Text("ID: ");
        TextField idPolje = new TextField();
        Text ime = new Text("Ime: ");
        TextField imePolje = new TextField();
        Text prezime = new Text("Prezime: ");
        TextField prezimePolje = new TextField();
        Text godiste = new Text("Godiste: ");
        TextField godistePolje = new TextField();
        Text firma = new Text("Firma: ");
        TextField firmaPolje = new TextField();

        pane.add(id, 0, 1);
        pane.add(idPolje, 1, 1);
        pane.add(ime, 0, 2);
        pane.add(imePolje, 1, 2);
        pane.add(prezime, 0, 3);
        pane.add(prezimePolje, 1, 3);
        pane.add(godiste, 0, 4);
        pane.add(godistePolje, 1, 4);
        pane.add(firma, 0, 5);
        pane.add(firmaPolje, 1, 5);

        
        
        
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
            String ime1 = imePolje.getText();
            String prezime1 = prezimePolje.getText();
            int godiste1 = Integer.parseInt(godistePolje.getText());
            String firma1 = firmaPolje.getText();
            BazaKorisnik.updateKorisnike(id1, new Korisnik(ime1, prezime1, godiste1, firma1));
        });

        dugme2.setOnAction((ActionEvent event) -> {
            Grafika grafika = new Grafika();
            grafika.start(primaryStage);
        });

        Scene scene = new Scene(pane1, 300, 300);

        primaryStage.setTitle("Izmeni:");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
