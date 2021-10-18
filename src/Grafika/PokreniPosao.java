package Grafika;

import Baza.BazaKorisnik;
import java.util.logging.Level;
import java.util.logging.Logger;
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

public class PokreniPosao extends Application {

    public static int id;
    public static Korisnik zaPracenje;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(0, 10, 0, 10));
        Text id = new Text("ID korisnika: ");

        TextField idPolje = new TextField();

        pane.add(id, 0, 1);
        pane.add(idPolje, 1, 1);

        Button dugme1 = new Button("Pokreni");
        dugme1.setMinWidth(130);
        pane.add(dugme1, 0, 3);
        Button dugme2 = new Button("Izadji");
        dugme2.setMaxWidth(220);
        pane.add(dugme2, 1, 3);

        Image image = new Image("file:SLIKA.jpg", 260, 230, false, false);
        ImageView iv = new ImageView();
        iv.setImage(image);
        StackPane pane1 = new StackPane();
        pane1.getChildren().addAll(iv, pane);

        dugme1.setOnAction((ActionEvent event) -> {
            zaPracenje = BazaKorisnik.getKorisnik(Integer.parseInt(idPolje.getText()));
            PregledajPoId pregledanje = new PregledajPoId();
            setId(Integer.parseInt(idPolje.getText()));
            
            try {
                pregledanje.start(primaryStage);
            } catch (Exception ex) {
                Logger.getLogger(PokreniPosao.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        dugme2.setOnAction((ActionEvent event) -> {
            Grafika grafika = new Grafika();
            grafika.start(primaryStage);
        });

        Scene scene = new Scene(pane1, 260, 230);
        
        primaryStage.setTitle("Pokreni:");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
