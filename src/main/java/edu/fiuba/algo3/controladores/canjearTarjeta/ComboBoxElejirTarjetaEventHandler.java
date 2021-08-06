package edu.fiuba.algo3.controladores.canjearTarjeta;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;
import java.util.Objects;

public class ComboBoxElejirTarjetaEventHandler implements EventHandler<ActionEvent> {
    private ArrayList<String> tarjetas;
    private ComboBox<String> opcionElejida;
    private ComboBox<String> otraOpcion1;
    private ComboBox<String> otraOpcion2;


    public ComboBoxElejirTarjetaEventHandler(ArrayList<String> tarjetas, ComboBox<String> opcionElejida, ComboBox<String> otraOpcion1, ComboBox<String> otraOpcion2) {
        this.tarjetas = tarjetas;
        this.opcionElejida = opcionElejida;
        this.otraOpcion1 = otraOpcion1;
        this.otraOpcion2 = otraOpcion2;
    }

    @Override
    public void handle(ActionEvent actionEvent) {


        String paisSelecionado1 = otraOpcion1.getValue();
        String paisSelecionado2 = otraOpcion2.getValue();

        if (Objects.equals(opcionElejida.getValue(), paisSelecionado1)) {
            otraOpcion1.setValue(null);
        }
        if (Objects.equals(opcionElejida.getValue(), paisSelecionado2)) {
            otraOpcion2.setValue(null);
        }
    }
}
