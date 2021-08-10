package edu.fiuba.algo3.controladores.ataqueReagrupacionColocacion;

import edu.fiuba.algo3.controladores.ControladorMaestro;
import edu.fiuba.algo3.vistas.escenasEtapas.EscenaReagrupacionDeTropas;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonAvanzarAReagrupacionEventHandler implements EventHandler {
    private Stage stage;
    private ControladorMaestro controladorMaestro;

    public BotonAvanzarAReagrupacionEventHandler(Stage stageRecibida, ControladorMaestro controladorMaestro)   {
        stage = stageRecibida;
        this.controladorMaestro = controladorMaestro;
    }

    @Override
    public void handle(Event event) {
        controladorMaestro.avanzarEtapa();
        Scene nuevaEscena = EscenaReagrupacionDeTropas.crearEscenaReagrupacion(stage, controladorMaestro);
        stage.setScene(nuevaEscena);
        stage.show();
    }
}
