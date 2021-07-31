package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.vistas.EscenaColocacionDeNuevasTropas;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonAvanzarAColocacionEventHandler implements EventHandler {
    private Stage stage;
    private ControladorMaestro controladorMaestro;

    public BotonAvanzarAColocacionEventHandler(Stage stageRecibida, ControladorMaestro controladorMaestro)   {
        stage = stageRecibida;
        this.controladorMaestro = controladorMaestro;
    }

    @Override
    public void handle(Event event) {

            Scene nuevaEscena =  EscenaColocacionDeNuevasTropas.crearEscenaColocacion(controladorMaestro);
            stage.setScene(nuevaEscena);
            stage.show();
        }
}

