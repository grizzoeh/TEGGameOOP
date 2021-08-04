package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.vistas.EscenaReglas;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonVerReglasEventHandler implements EventHandler<ActionEvent> {
    private  Stage stage;
    public BotonVerReglasEventHandler(Stage stage) {
        this.stage = stage;
    }


    @Override
    public void handle(ActionEvent event) {
        Scene escena = EscenaReglas.crearEscenaReglas(stage);
        stage.setScene(escena);
        stage.show();
    }
}
