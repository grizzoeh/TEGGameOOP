package edu.fiuba.algo3.controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;

public class ElegirPaisParaAtacarEventHandler implements EventHandler<ActionEvent> {
    private ControladorMaestro controladorMaestro;
    private ComboBox paisesHacia;
    private ComboBox paisesDesde;
    private ComboBox cantidad;


    public ElegirPaisParaAtacarEventHandler(ControladorMaestro controladorMaestro, ComboBox paisesDesde, ComboBox paisesHacia, ComboBox cantidadDeFichas) {
        this.controladorMaestro = controladorMaestro;
        this.paisesHacia = paisesHacia;
        this.paisesDesde = paisesDesde;
        this.cantidad = cantidadDeFichas;

    }

    @Override
    public void handle(ActionEvent event) {
        paisesHacia.getItems().clear();
        cantidad.getItems().clear();
        colocarCantidad();
        paisesHacia.getItems().addAll(controladorMaestro.paisesQueSePuedenAtacarDesde((String) paisesDesde.getValue()));
    }
    public void colocarCantidad(){
        for (int i = 0; i < controladorMaestro.tropasDisponiblesEn((String) paisesDesde.getValue()); i++ ){
            cantidad.getItems().add(i+1);
        }

    }
}
