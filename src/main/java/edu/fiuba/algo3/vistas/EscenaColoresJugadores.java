package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.BotonAvanzarAReagrupacionEventHandler;
import edu.fiuba.algo3.controladores.BotonComezarPartidaEventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;


public class EscenaColoresJugadores {
    public static Scene crearSceneColoresJugadores (Stage stage, ArrayList<String> jugadores) {
        Label cartel = new Label("Jugadores en orden de jugada");
        cartel.setFont(new Font("Serif", 20));

        VBox tablero = new VBox(cartel);
        tablero.setSpacing(20);
        tablero.setAlignment(Pos.CENTER);

        String[] colores = {"Rojo", "Azul", "Verde", "Amarillo", "Rosa", "Negro"};
        String[] coloresHex = {"cc3311", "0077bb", "009988", "ee7733", "ee3377", "000000"};

        for (int i = 0; i < jugadores.size(); i++) {
            Label labelAux = new Label(jugadores.get(i) + " - " + colores[i]);
            labelAux.setTextFill(Color.web(coloresHex[i]));
            tablero.getChildren().add(labelAux);
        }

        Button botonSiguiente = new Button("Empezar juego");
        botonSiguiente.setOnAction(new BotonComezarPartidaEventHandler(stage));

        tablero.getChildren().add(botonSiguiente);

        return new Scene(tablero, 1080, 720);
    }
}
