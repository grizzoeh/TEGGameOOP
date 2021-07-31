package edu.fiuba.algo3.vistas;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class SelectorDeColocacion {
    public static HBox crearSelector(Button boton){

        Label paisesLabel = new Label("Paises Disponibles:");
        ComboBox paises = new ComboBox();
        paises.getItems().addAll(
                "Paises..."
        );
        TextField cantFichas = new TextField();
        cantFichas.setPromptText("Fichas Disponibles: [X]");

        Button agregarButton = new Button();
        agregarButton.setText("Agregar");

        Label fichas = new Label("Fichas:");


        boton.setText("Avanzar Etapa");
        boton.setAlignment(Pos.CENTER_RIGHT);


        HBox seleccionador = new HBox(paisesLabel,paises,fichas,cantFichas, agregarButton, boton);
        return seleccionador;
    }
}
