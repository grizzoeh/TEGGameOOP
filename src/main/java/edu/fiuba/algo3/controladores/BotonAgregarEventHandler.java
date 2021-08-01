package edu.fiuba.algo3.controladores;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class BotonAgregarEventHandler implements EventHandler {
    private ControladorMaestro controladorMaestro;
    private ComboBox cajaPaises;
    private TextField fichas;

    public BotonAgregarEventHandler(ControladorMaestro controladorMaestro, ComboBox cajaPaises, TextField fichas) {
        this.controladorMaestro = controladorMaestro;
        this.cajaPaises = cajaPaises;
        this.fichas = fichas;
    }


    @Override
    public void handle(Event event) {
        if (cajaPaises.getValue() == null) { return; }
        if (fichas.getText().trim().equals("")) { return; }
        int cantidad = 0;

        try {
            cantidad = Integer.parseInt(fichas.getText().trim());
        } catch (NumberFormatException nfe) {
            return;
        }
        if (cantidad < 0) { return; }

        String pais = (String) cajaPaises.getValue();
        controladorMaestro.asignarFichas(cantidad ,(String) cajaPaises.getValue());

        fichas.clear();
        fichas.setPromptText("Fichas Disponibles: " + controladorMaestro.fichasDisponiblesJugadorActual());

    }
}
