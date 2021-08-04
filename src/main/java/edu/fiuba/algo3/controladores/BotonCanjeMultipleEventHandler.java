package edu.fiuba.algo3.controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;

public class BotonCanjeMultipleEventHandler implements EventHandler<ActionEvent> {
    private ControladorMaestro controladorMaestro;
    private HBox canjeMultiple;

    public BotonCanjeMultipleEventHandler(ControladorMaestro controladorMaestro, HBox canjeMultiple) {
        this.controladorMaestro = controladorMaestro;
        this.canjeMultiple = canjeMultiple;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        String pais1 = ((ComboBox<String>) canjeMultiple.getChildren().get(0)).getValue();
        String pais2 = ((ComboBox<String>) canjeMultiple.getChildren().get(1)).getValue();
        String pais3 = ((ComboBox<String>) canjeMultiple.getChildren().get(2)).getValue();

        if (pais1 == null || pais2 == null || pais3 == null) {
            return;
        }

        pais1 = pais1.split(" - ")[0];
        pais2 = pais2.split(" - ")[0];
        pais3 = pais3.split(" - ")[0];

        if (controladorMaestro.sePuedenCanjearTarjetas(pais1, pais2, pais3)) {
            controladorMaestro.canjearTarjetaMultiple(pais1, pais2, pais3);


        }
    }
}
