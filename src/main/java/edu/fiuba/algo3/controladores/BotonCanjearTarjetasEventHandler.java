package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.controladores.ControladorMaestro;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BotonCanjearTarjetasEventHandler implements EventHandler<ActionEvent> {
    private  ControladorMaestro controladorMaestro;

    public BotonCanjearTarjetasEventHandler(ControladorMaestro controladorMaestro) {
        this.controladorMaestro = controladorMaestro;
    }

    @Override
    public void handle(ActionEvent event) {
        ArrayList<String> tarjetas = controladorMaestro.mostrarTodasTarjetasJugadorActual();
    }
}
