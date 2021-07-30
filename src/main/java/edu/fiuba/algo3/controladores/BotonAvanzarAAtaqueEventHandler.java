package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.vistas.EscenaEtapaAtaque;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonAvanzarAAtaqueEventHandler implements EventHandler<ActionEvent> {
    private Stage stage;
    private Scene scene;


    public BotonAvanzarAAtaqueEventHandler(Stage stageRecibida, Scene sceneRecibida)   {
        stage = stageRecibida;
        scene = sceneRecibida;
    }

    @Override
    public void handle(ActionEvent event) {
        Scene nuevaEscena = EscenaEtapaAtaque.crearEscenaEtapaAtaque(stage);
        stage.setScene(nuevaEscena);
        stage.show();
    }
}
