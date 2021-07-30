package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.vistas.EscenaReagrupacionDeTropas;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonAvanzarAReagrupacionEventHandler implements EventHandler {
    private Stage stage;
    private Scene scene;

    public BotonAvanzarAReagrupacionEventHandler(Stage stageRecibida, Scene sceneRecibida)   {
        stage = stageRecibida;
        scene = sceneRecibida;
    }

    @Override
    public void handle(Event event) {
        Scene nuevaEscena = EscenaReagrupacionDeTropas.crearEscenaReagrupacion(scene, stage);
        stage.setScene(nuevaEscena);
        stage.show();
    }
}
