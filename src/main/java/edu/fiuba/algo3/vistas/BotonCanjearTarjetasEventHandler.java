package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.ControladorMaestro;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonCanjearTarjetasEventHandler implements EventHandler<ActionEvent> {
    private  ControladorMaestro controladorMaestro;

    public BotonCanjearTarjetasEventHandler(ControladorMaestro controladorMaestro) {
        this.controladorMaestro = controladorMaestro;
    }

    @Override
    public void handle(ActionEvent event) {

    }
}
