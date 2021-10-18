package Grafika;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Grafika extends Application {

    @Override
    public void start(Stage primaryStage) {
        
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        Button dugme1 = new Button("Novi korisnik");
        dugme1.setMinWidth(150);
        Button dugme2 = new Button("Pregledaj korisnike");
        dugme2.setMinWidth(150);
        Button dugme3 = new Button("Obrisi korisnike");
        dugme3.setMinWidth(150);
        Button dugme4 = new Button("Izmeni korisnike");
        dugme4.setMinWidth(150);
        Button dugme5 = new Button("Novi posao");
        dugme5.setMinWidth(150);
        Button dugme6 = new Button("Pregledaj poslove");
        dugme6.setMinWidth(150);
        Button dugme7 = new Button("Obrisi poslove");
        dugme7.setMinWidth(150);
        Button dugme8 = new Button("Izmeni poslove");
        dugme8.setMinWidth(150);
        Button dugme9 = new Button("Pokreni posao");
        dugme9.setMinWidth(150);
        Button dugmeIzlaz = new Button("EXIT");
        dugmeIzlaz.setMinWidth(150);

        grid.add(dugme1, 2, 15);
        grid.add(dugme2, 3, 15);
        grid.add(dugme3, 2, 16);
        grid.add(dugme4, 3, 16);
        grid.add(dugme5, 2, 18);
        grid.add(dugme6, 3, 18);
        grid.add(dugme7, 2, 19);
        grid.add(dugme8, 3, 19);
        grid.add(dugme9, 4, 17);
        grid.add(dugmeIzlaz, 4, 31);

        Image image = new Image("file:POZADINA.jpg", 500, 500, false, false);
        ImageView iv = new ImageView();
        iv.setImage(image);
        StackPane pane1 = new StackPane();
        pane1.getChildren().addAll(iv, grid);
        Scene scene = new Scene(pane1, 500, 500);

        dugme1.setOnAction((ActionEvent event) -> {
            UnesiKorisnika unesiKorisnika = new UnesiKorisnika();
            try {
                unesiKorisnika.start(primaryStage);
            } catch (Exception ex) {
                Logger.getLogger(Grafika.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        dugme2.setOnAction((ActionEvent event) -> {
            PregledajKorisnike pregledajKorisnike = new PregledajKorisnike();
            try {
                pregledajKorisnike.start(primaryStage);
            } catch (Exception exe) {
                Logger.getLogger(Grafika.class.getName()).log(Level.SEVERE, null, exe);
            }
        });

        dugme3.setOnAction((ActionEvent event) -> {
            ObrisiKorisnike obrisiKorisnike = new ObrisiKorisnike();
            try {
                obrisiKorisnike.start(primaryStage);
            } catch (Exception exec) {
                Logger.getLogger(Grafika.class.getName()).log(Level.SEVERE, null, exec);
            }
        });

        dugme4.setOnAction((ActionEvent event) -> {
            IzmeniKorisnike izmeniKorisnike = new IzmeniKorisnike();
            try {
                izmeniKorisnike.start(primaryStage);
            } catch (Exception exece) {
                Logger.getLogger(Grafika.class.getName()).log(Level.SEVERE, null, exece);
            }
        });

        dugme5.setOnAction((ActionEvent event) -> {
            UnesiPosao unesiPosao = new UnesiPosao();
            try {
                unesiPosao.start(primaryStage);
            } catch (Exception ex) {
                Logger.getLogger(Grafika.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        dugme6.setOnAction((ActionEvent event) -> {
            PregledajPoslove pregledajPoslove = new PregledajPoslove();
            try {
                pregledajPoslove.start(primaryStage);
            } catch (Exception ex) {
                Logger.getLogger(Grafika.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        dugme7.setOnAction((ActionEvent event) -> {
            ObrisiPosao obrisiPosao = new ObrisiPosao();
            try {
                obrisiPosao.start(primaryStage);
            } catch (Exception ex) {
                Logger.getLogger(Grafika.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        dugme8.setOnAction((ActionEvent event) -> {
            IzmeniPoslove izmeniPosao = new IzmeniPoslove();
            try {
                izmeniPosao.start(primaryStage);
            } catch (Exception ex) {
                Logger.getLogger(Grafika.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        dugme9.setOnAction((ActionEvent event) -> {
            PokreniPosao pokreniPosao = new PokreniPosao();
            try {
                pokreniPosao.start(primaryStage);
            } catch (Exception ex) {
                Logger.getLogger(Grafika.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        dugmeIzlaz.setOnAction((ActionEvent event) -> {
            Stage stage = (Stage)dugmeIzlaz.getScene().getWindow();
            stage.close();
        });

        primaryStage.setTitle("");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
