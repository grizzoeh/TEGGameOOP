package edu.fiuba.algo3.controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class BotonElegirPaisAReagruparEventHandler implements EventHandler<ActionEvent> {
    private ControladorMaestro controladorMaestro;
    private ComboBox desde;
    private ComboBox hacia;
    private ComboBox cantidad;
    private Label label;

    public BotonElegirPaisAReagruparEventHandler(ControladorMaestro controladorMaestro, ComboBox paisesDesde, ComboBox paisesHacia, ComboBox cantidadDeFichas) {
        this.controladorMaestro = controladorMaestro;
        desde = paisesDesde;
        hacia = paisesHacia;
        cantidad = cantidadDeFichas;
    }

    @Override
    public void handle(ActionEvent event) {
        hacia.getItems().clear();
        cantidad.getItems().clear();

        hacia.getItems().addAll(controladorMaestro.paisesAliadosEnFronteraDe((String) desde.getValue()));

        agregarCantidad();


    }
    public void agregarCantidad(){
        for(int i = 0; i < controladorMaestro.tropasDisponiblesEn((String) desde.getValue()); i++){
            cantidad.getItems().add(i+1);
        }
    }
}
