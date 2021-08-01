package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.vistas.EscenaEtapaAtaque;
import edu.fiuba.algo3.vistas.EscenaEtapaInicial;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonAvanzarAAtaqueEventHandler implements EventHandler<ActionEvent> {
    private Stage stage;
    private ControladorMaestro controladorMaestro;


    public BotonAvanzarAAtaqueEventHandler(Stage stageRecibida, ControladorMaestro controladorMaestro)   {
        stage = stageRecibida;
        this.controladorMaestro = controladorMaestro;
    }

    @Override
    public void handle(ActionEvent event) {
        controladorMaestro.avanzarEtapa();

        if (controladorMaestro.etapaActual().equals("Ataque Entre Jugadores")) {
            Scene nuevaEscena = EscenaEtapaAtaque.crearEscenaEtapaAtaque(stage, controladorMaestro);
            stage.setScene(nuevaEscena);
            stage.show();
            return;
        }
        Scene nuevaEscena = EscenaEtapaInicial.crearSceneEtapaInicial(stage, controladorMaestro);
        stage.setScene(nuevaEscena);
        stage.show();
    }
}
