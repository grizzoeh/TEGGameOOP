package edu.fiuba.algo3.controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BotonAtacarEventHandler implements EventHandler<ActionEvent> {
    private Stage stage;
    private ComboBox desde;
    private ComboBox hacia;
    private ComboBox cant;
    private ControladorMaestro controladorMaestro;
    private Label error;

    public BotonAtacarEventHandler(Stage stage, ControladorMaestro controladorMaestro, ComboBox paisesDesde, ComboBox paisesHacia, ComboBox cantidadDeFichas, Label mostradorError) {
        this.stage = stage;
        this.controladorMaestro = controladorMaestro;
        desde = paisesDesde;
        hacia = paisesHacia;
        cant = cantidadDeFichas;
        error = mostradorError;
    }

    @Override
    public void handle(ActionEvent event) {
        if (desde.getValue() == null){
            error.setText("Debes Seleccionar Un Pais Para Atacar");
            error.setTextFill(Color.RED);
            return;
        }
        if (hacia.getValue() == null){
            error.setText("Debes Seleccionar Un Pais Para Ser Atacado");
            error.setTextFill(Color.RED);
            return;
        }
        if (cant.getValue() == null){
            error.setText("Debes Seleccionar Una Cantidad De Tropas");
            error.setTextFill(Color.RED);
            return;
        }
        controladorMaestro.atacar((String) desde.getValue(), (String) hacia.getValue(), (int )cant.getValue());
        desde.getItems().clear();
        desde.getItems().addAll(controladorMaestro.paisesPuedenAtacar());

        hacia.getItems().clear();
        cant.getItems().clear();

        error.setText("Ataque Lanzado");
        error.setTextFill(Color.GREEN);

    }
}
