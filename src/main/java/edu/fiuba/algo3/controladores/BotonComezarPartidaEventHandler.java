package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.vistas.EscenaColoresJugadores;
import edu.fiuba.algo3.vistas.EscenaEtapaInicial;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonComezarPartidaEventHandler implements EventHandler<ActionEvent> {
    Stage stage;

    public BotonComezarPartidaEventHandler(Stage stageRecibida) {
        stage = stageRecibida;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Scene scene = EscenaEtapaInicial.crearSceneEtapaInicial(stage);
        stage.setScene(scene);
        stage.show();
    }
}
