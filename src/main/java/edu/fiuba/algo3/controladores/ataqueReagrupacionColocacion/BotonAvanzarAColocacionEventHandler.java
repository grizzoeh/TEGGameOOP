package edu.fiuba.algo3.controladores.ataqueReagrupacionColocacion;

import edu.fiuba.algo3.controladores.ControladorMaestro;
import edu.fiuba.algo3.vistas.escenasEtapas.EscenaColocacionDeNuevasTropas;
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
            controladorMaestro.avanzarEtapa();
            Scene nuevaEscena =  EscenaColocacionDeNuevasTropas.crearEscenaColocacion(stage, controladorMaestro);
            stage.setScene(nuevaEscena);
            stage.show();
        }
}

