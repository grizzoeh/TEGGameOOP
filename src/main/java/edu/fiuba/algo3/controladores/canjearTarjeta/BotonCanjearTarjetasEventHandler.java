package edu.fiuba.algo3.controladores.canjearTarjeta;

import edu.fiuba.algo3.controladores.ControladorMaestro;
import edu.fiuba.algo3.vistas.ataqueReagrupacionColocacion.EscenaCanjearTarjetas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

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
            error.setText("No tienes tarjetas para canjear");
            error.setTextFill(Color.RED);
            return;
        }

        Scene nuevaScene = EscenaCanjearTarjetas.crearEscenaCanjearTarjetas(stage ,controladorMaestro, stage.getScene());
        stage.setScene(nuevaScene);
        stage.show();

    }
}
