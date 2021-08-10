package edu.fiuba.algo3.controladores.informacion;

import edu.fiuba.algo3.controladores.ControladorMaestro;
import edu.fiuba.algo3.controladores.ProveedorDeConstantes;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;


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
        ((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image(ProveedorDeConstantes.obtenerDireccionIconoObjetivo()));
        alert.showAndWait();
    }




}
