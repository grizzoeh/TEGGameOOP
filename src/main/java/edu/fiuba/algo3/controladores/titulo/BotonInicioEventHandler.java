package edu.fiuba.algo3.controladores.titulo;

import edu.fiuba.algo3.vistas.escenasGenerales.EscenaIntroducirJugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonInicioEventHandler implements EventHandler<ActionEvent> {
    private Stage stage;
    private Scene sceneBienvenida;


    public BotonInicioEventHandler(Stage stageRecibida, Scene sceneRec) {
        stage = stageRecibida;
        sceneBienvenida = sceneRec;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Scene sceneCreacionJugadores = EscenaIntroducirJugadores.crearSceneJugadores(sceneBienvenida, stage);
        stage.setScene(sceneCreacionJugadores);
        stage.show();

    }
}