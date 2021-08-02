package edu.fiuba.algo3.vistas;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class EscenaFinal {


     public static Scene crearEscenaFinal(Stage stage, String nombreGanador){
         Label anunciante =  new Label(nombreGanador);
         HBox hBox = new HBox(anunciante);
         hBox.setAlignment(Pos.CENTER);
         return new Scene(hBox, 1080, 720);
    }
}
