package edu.fiuba.algo3.controladores.introducirJugadores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class EnviarCantJugadoresEventHandler implements EventHandler<ActionEvent> {
    private VBox vbox;
    private ComboBox dropdown;
    private Button botonEnviar;

    public EnviarCantJugadoresEventHandler(VBox VBoxrecibida, ComboBox dropdownRecibido, Button botonEnviar) {

        vbox = VBoxrecibida;
        dropdown = dropdownRecibido;
        this.botonEnviar = botonEnviar;

    }

    @Override
    public void handle(ActionEvent actionEvent) {

        String numero = (String) dropdown.getValue();
        Integer numeroInteger = Integer.parseInt(numero);

        vbox.getChildren().removeAll(vbox.getChildren());

        for (Integer i = 0; i<numeroInteger; i++){
            TextField textFieldAux = new TextField();
            textFieldAux.setPromptText("Nombre Jugador "+ Integer.toString(i+1));
            textFieldAux.setOnKeyPressed(new TextoIntroducidoEventHandler(botonEnviar));
            vbox.getChildren().add(textFieldAux);

        }



    }
}