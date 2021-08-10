package edu.fiuba.algo3.vistas.escenasDeInformacion;

import edu.fiuba.algo3.controladores.informacion.BotonVolverATableroEventHandler;
import edu.fiuba.algo3.controladores.ControladorMaestro;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class EscenaMostrarTarjetas {

    public static Scene crearEscenaMostrarTarjetas(Stage stage, ControladorMaestro controladorMaestro) {

        VBox columnaCartas = new VBox();
        columnaCartas.setSpacing(20);

        ArrayList<String> cartas = controladorMaestro.mostrarTodasTarjetasJugadorActual();

        if (cartas.size() == 0) {
            columnaCartas.getChildren().add(new Label("No tenes cartas"));
        }

        for (String carta : cartas) {
            Label cartaLabel = new Label(carta);
            columnaCartas.getChildren().add(cartaLabel);
        }

        Button botonVolver = new Button();
        botonVolver.setText("Continuar el juego");
        botonVolver.setOnAction(new BotonVolverATableroEventHandler(stage, stage.getScene()));
        columnaCartas.getChildren().add(botonVolver);

        columnaCartas.setAlignment(Pos.CENTER);

        return new Scene(columnaCartas, 1080, 720);

    }
}
