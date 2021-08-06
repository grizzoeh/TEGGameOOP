package edu.fiuba.algo3.controladores.mostrarJugadores;

import edu.fiuba.algo3.controladores.ControladorMaestro;
import edu.fiuba.algo3.vistas.escenasEtapas.EscenaEtapaInicial;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonComezarPartidaEventHandler implements EventHandler<ActionEvent> {
    Stage stage;
    ControladorMaestro controladorMaestro;

    public BotonComezarPartidaEventHandler(Stage stageRecibida, ControladorMaestro controladorMaestro) {
        stage = stageRecibida;
        this.controladorMaestro = controladorMaestro;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Scene scene = EscenaEtapaInicial.crearSceneEtapaInicial(stage, controladorMaestro);
        stage.setScene(scene);
        stage.show();
    }
}
