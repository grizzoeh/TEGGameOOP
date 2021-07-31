package edu.fiuba.algo3.controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;



public class BotonObjetivoEventHandler implements EventHandler<ActionEvent> {
    ControladorMaestro controladorMaestro;

    public BotonObjetivoEventHandler(ControladorMaestro controladorMaestro) {
        this.controladorMaestro = controladorMaestro;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Objetivo");
        alert.setHeaderText("");
        alert.setContentText(controladorMaestro.objetivoJugadorActual());

        alert.showAndWait();
    }




}
