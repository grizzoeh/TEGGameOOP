package edu.fiuba.algo3.controladores.informacion;

import edu.fiuba.algo3.controladores.ControladorMaestro;
import edu.fiuba.algo3.vistas.escenasDeInformacion.EscenaMostrarTarjetas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class BotonMostrarTarjetasEventHandler implements EventHandler<ActionEvent> {
    private Stage stage;
    private ControladorMaestro controladorMaestro;

    public BotonMostrarTarjetasEventHandler(Stage stage, ControladorMaestro controladorMaestro) {
        this.stage = stage;
        this.controladorMaestro = controladorMaestro;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Scene nuevaEscena = EscenaMostrarTarjetas.crearEscenaMostrarTarjetas(stage, controladorMaestro);
        stage.setScene(nuevaEscena);
        stage.show();


    }
}
