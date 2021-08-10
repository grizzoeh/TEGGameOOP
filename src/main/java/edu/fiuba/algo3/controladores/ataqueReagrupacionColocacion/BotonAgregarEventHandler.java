package edu.fiuba.algo3.controladores.ataqueReagrupacionColocacion;

import edu.fiuba.algo3.controladores.ControladorMaestro;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BotonAgregarEventHandler implements EventHandler {
    private ControladorMaestro controladorMaestro;
    private ComboBox cajaPaises;
    private TextField fichas;
    private Label errores;

    public BotonAgregarEventHandler(ControladorMaestro controladorMaestro, ComboBox cajaPaises, TextField fichas, Label errores) {
        this.controladorMaestro = controladorMaestro;
        this.cajaPaises = cajaPaises;
        this.fichas = fichas;
        this.errores = errores;
    }


    @Override
    public void handle(Event event) {
        if (cajaPaises.getValue() == null) {
            errores.setText("Debes Seleccionar Un Pais");
            return;
        }
        if (fichas.getText().trim().equals("")) {
            errores.setText("Debes Seleccionar Una Cantidad");
            return;
        }
        int cantidad = 0;

        try {
            cantidad = Integer.parseInt(fichas.getText().trim());
        } catch (NumberFormatException nfe) {
            errores.setText("Esa No Es Una Cantidad Valida");
            return;
        }
        if (cantidad < 0) {
            errores.setText("La Cantidad Debe Ser Mayor a Cero");
            return; }

        errores.setText("");

        String pais = (String) cajaPaises.getValue();
        controladorMaestro.asignarFichas(cantidad ,(String) cajaPaises.getValue());

        fichas.clear();
        fichas.setPromptText("Fichas Disponibles: " + controladorMaestro.fichasDisponiblesJugadorActual());

    }
}
