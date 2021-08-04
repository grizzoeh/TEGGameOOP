package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.aexcepciones.JuegoTerminadoException;
import edu.fiuba.algo3.vistas.EscenaEtapaAtaque;
import edu.fiuba.algo3.vistas.EscenaEtapaInicial;
import edu.fiuba.algo3.vistas.EscenaFinal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class BotonAvanzarAAtaqueEventHandler implements EventHandler<ActionEvent> {
    private Stage stage;
    private ControladorMaestro controladorMaestro;


    public BotonAvanzarAAtaqueEventHandler(Stage stageRecibida, ControladorMaestro controladorMaestro)   {
        stage = stageRecibida;
        this.controladorMaestro = controladorMaestro;
    }

    @Override
    public void handle(ActionEvent event) {
        Scene nuevaEscena = null;
        try {
            controladorMaestro.avanzarEtapa();
        }catch (JuegoTerminadoException e){
            try {
                nuevaEscena = EscenaFinal.crearEscenaFinal(stage, e.obtenerNombreGanador(), e.obtenerColorGanador());
            } catch (LineUnavailableException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (UnsupportedAudioFileException ex) {
                ex.printStackTrace();
            }
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
