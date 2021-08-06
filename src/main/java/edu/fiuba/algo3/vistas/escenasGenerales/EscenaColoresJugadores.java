package edu.fiuba.algo3.vistas.escenasGenerales;

import edu.fiuba.algo3.controladores.informacion.BotonVerReglasEventHandler;
import edu.fiuba.algo3.controladores.mostrarJugadores.BotonComezarPartidaEventHandler;
import edu.fiuba.algo3.controladores.ControladorMaestro;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;


public class EscenaColoresJugadores {
    public static Scene crearSceneColoresJugadores (Stage stage, ControladorMaestro controladorMaestro , ArrayList<String> jugadores) {

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
        Button verReglas = new Button("Reglas");
        verReglas.setPrefSize(70, 25);
        verReglas.setOnAction(new BotonVerReglasEventHandler(stage));
        Button botonSiguiente = new Button("Empezar juego");
        botonSiguiente.setFont(new Font(14));

        botonSiguiente.setOnAction(new BotonComezarPartidaEventHandler(stage, controladorMaestro));
        botonSiguiente.requestFocus();
        botonSiguiente.setPrefSize(140,45);
        VBox botones = new VBox( verReglas, botonSiguiente);
        botones.setAlignment(Pos.CENTER);
        botones.setSpacing(10);
        tablero.getChildren().add(botones);

        return new Scene(tablero, 1080, 720);
    }
}
