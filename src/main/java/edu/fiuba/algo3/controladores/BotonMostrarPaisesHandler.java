package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.vistas.EscenaMostrarPaises;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
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
