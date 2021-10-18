package Grafika;

import Grafika.PokreniPosao;
import Grafika.Grafika;
import Baza.BazaPoslovi;
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
import javax.swing.JOptionPane;
import Paketi.Posao;
import Paketi.PosaoTh;

public class Pracenje extends Application {

    PosaoTh posao;

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane pane = new GridPane();
        pane.setHgap(5);
        pane.setVgap(5);
        pane.setAlignment(Pos.CENTER);

        TextArea tekst = new TextArea();

        pane.add(tekst, 0, 1);

        Posao pos = BazaPoslovi.procitajPosaoId(PokreniPosao.id).get(0);

        for (Posao posao : BazaPoslovi.procitajPosaoId(PokreniPosao.id)) {
            tekst.appendText(posao + "\n");
        }

        Button button = new Button("Nazad");
        Button button1 = new Button("Start");
        Button button2 = new Button("Stop");

        pane.add(button1, 0, 5);
        pane.add(button2, 0, 6);
        pane.add(button, 0, 7);

        Image image = new Image("file:SLIKA.jpg", 500, 500, false, false);
        ImageView iv = new ImageView();
        iv.setImage(image);
        StackPane pane1 = new StackPane();
        pane1.getChildren().addAll(iv, pane);

        button1.setOnAction((ActionEvent event) -> {
            posao = new PosaoTh(pos.getSatnica(), PokreniPosao.zaPracenje);
            JOptionPane.showMessageDialog(null, "Posao je zapocet");
        });

        button2.setOnAction((ActionEvent event) -> {
            if (posao != null) {
                posao.stopPosao();
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
