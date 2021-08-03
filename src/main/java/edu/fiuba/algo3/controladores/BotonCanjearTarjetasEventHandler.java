package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.controladores.ControladorMaestro;
import edu.fiuba.algo3.vistas.EscenaCanjearTarjetas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BotonCanjearTarjetasEventHandler implements EventHandler<ActionEvent> {
    private  ControladorMaestro controladorMaestro;
    private Stage stage;
    private Label error;

    public BotonCanjearTarjetasEventHandler(Stage stage, ControladorMaestro controladorMaestro, Label error) {
        this.controladorMaestro = controladorMaestro;
        this.stage = stage;
        this.error = error;
    }

    @Override
    public void handle(ActionEvent event) {
        if (controladorMaestro.mostrarTodasTarjetasJugadorActual().size() == 0) {
            error.setText("No tienes tarjetas");
            error.setTextFill(Color.RED);
            return;
        }

        Scene nuevaScene = EscenaCanjearTarjetas.crearEscenaCanjearTarjetas(stage ,controladorMaestro);
        stage.setScene(nuevaScene);
        stage.show();

    }
}
