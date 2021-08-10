package edu.fiuba.algo3.controladores.informacion;

import edu.fiuba.algo3.controladores.ControladorMaestro;
import edu.fiuba.algo3.vistas.escenasDeInformacion.EscenaMostrarPaises;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonMostrarPaisesHandler implements EventHandler<ActionEvent> {

    private ControladorMaestro controladorMaestro;
    private Stage stage;

    public BotonMostrarPaisesHandler(Stage stage ,ControladorMaestro controladorMaestro) {
        this.controladorMaestro = controladorMaestro;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        Scene scenaPaises = EscenaMostrarPaises.crearEscenaMostrarPaises(stage, controladorMaestro, stage.getScene());
        stage.setScene(scenaPaises);
        stage.show();

    }
}
