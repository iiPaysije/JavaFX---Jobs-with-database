package Grafika;

import Grafika.Grafika;
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

public class UnesiKorisnika extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(0, 10, 0, 10));
        Text ime = new Text("Ime: ");
        Text prezime = new Text("Prezime: ");
        Text godiste = new Text("Godiste: ");
        Text firma = new Text("Firma: ");
        TextField imePolje = new TextField();
        TextField prezimePolje = new TextField();
        TextField godistePolje = new TextField();
        TextField firmaPolje = new TextField();
        pane.add(ime, 0, 1);
        pane.add(imePolje, 1, 1);
        pane.add(prezime, 0, 2);
        pane.add(prezimePolje, 1, 2);
        pane.add(godiste, 0, 3);
        pane.add(godistePolje, 1, 3);
        pane.add(firma, 0, 4);
        pane.add(firmaPolje, 1, 4);

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
            String ime1 = imePolje.getText();
            String prezime1 = prezimePolje.getText();
            int godiste1 = Integer.parseInt(godistePolje.getText());
            String firma1 = firmaPolje.getText();
            BazaKorisnik.insertKorisnik(new Korisnik(ime1, prezime1, godiste1, firma1));
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
