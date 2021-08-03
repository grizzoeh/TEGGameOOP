package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.aexcepciones.JuegoTerminadoException;
import edu.fiuba.algo3.vistas.EscenaEtapaAtaque;
import edu.fiuba.algo3.vistas.EscenaEtapaInicial;
import edu.fiuba.algo3.vistas.EscenaFinal;
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
        Scene nuevaEscena;
        try {
            controladorMaestro.avanzarEtapa();
        }catch (JuegoTerminadoException e){
            nuevaEscena = EscenaFinal.crearEscenaFinal(stage, e.obtenerNombreGanador(), e.obtenerColorGanador());
            stage.setScene(nuevaEscena);
            stage.show();
            return;
        }

        if (controladorMaestro.etapaActual().equals("Ataque Entre Jugadores")) {
            nuevaEscena = EscenaEtapaAtaque.crearEscenaEtapaAtaque(stage, controladorMaestro);
        }
        else{
            nuevaEscena = EscenaEtapaInicial.crearSceneEtapaInicial(stage, controladorMaestro);
        }
        stage.setScene(nuevaEscena);
        stage.show();
    }
}
