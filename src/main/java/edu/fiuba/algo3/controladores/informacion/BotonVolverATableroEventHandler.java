package edu.fiuba.algo3.controladores.informacion;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonVolverATableroEventHandler implements EventHandler<ActionEvent>{
    private Stage stage;
    private Scene sceneActual;


    public BotonVolverATableroEventHandler(Stage stage, Scene escenaActual) {
        this.stage = stage;
        this.sceneActual = escenaActual;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.setScene(sceneActual);
        stage.show();
    }
}
