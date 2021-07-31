package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.ControladorMaestro;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class SelectorDeColocacion {
    public static HBox crearSelector(Button boton, ControladorMaestro controladorMaestro){

        Label paisesLabel = new Label("Paises Disponibles:");
        ComboBox paises = new ComboBox();

        ArrayList<String> paisesControla = controladorMaestro.paisesJugadorActual();
        paises.getItems().addAll(paisesControla);
        TextField cantFichas = new TextField();
        cantFichas.setPromptText("Fichas Disponibles: " + controladorMaestro.fichasDisponiblesJugadorActual());

        Button agregarButton = new Button();
        agregarButton.setText("Agregar");

        Label fichas = new Label("Fichas:");


        boton.setText("Avanzar Etapa");
        boton.setAlignment(Pos.CENTER_RIGHT);


        HBox seleccionador = new HBox(paisesLabel,paises,fichas,cantFichas, agregarButton, boton);
        return seleccionador;
    }
}
