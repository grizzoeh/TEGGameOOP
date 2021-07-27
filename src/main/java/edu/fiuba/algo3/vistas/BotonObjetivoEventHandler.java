package edu.fiuba.algo3.vistas;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class BotonObjetivoEventHandler implements EventHandler<ActionEvent> {
    private Stage stage;

    public BotonObjetivoEventHandler(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println("xd");

        Label label = new Label("Objetivo:");
        label.setFont(new Font(18));
        Label objetivo = new Label("[Objetivo del Jugador Actual]");
        objetivo.setFont(new Font(14));
        VBox contenedor = new VBox(label, objetivo);

        var escena = new Scene(contenedor, 270, 180);

        stage.setScene(escena);


        return;
    }




}
