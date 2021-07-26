package edu.fiuba.algo3.vistas;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.util.ArrayList;


public class BotonPruebaEventHandler implements EventHandler<ActionEvent> {
    private Label label;
    private TextField texto;
    private ArrayList<String> palabras;

    public BotonPruebaEventHandler(Label label, TextField lectorTexto, ArrayList<String> palabrasRecibidas) {
            this.label = label;
            this.texto = lectorTexto;
            this.palabras = palabrasRecibidas;
        }

    @Override
    public void handle(ActionEvent actionEvent) {
        String textoRecibido;

        if (this.texto.getText().trim().equals("")) {
            this.label.setText("Debe ingresar un texto");
            this.label.setTextFill(Color.RED);
            this.texto.requestFocus();
        }
        else {
            textoRecibido = texto.getText();
            this.label.setText("Boton Presionado \npalabra recibida: " + textoRecibido);
            this.label.setTextFill(Color.DARKGREEN);
            palabras.add(textoRecibido);
            System.out.println(palabras);
            this.texto.clear();
            this.texto.requestFocus();

        }
    }
}

