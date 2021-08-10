package edu.fiuba.algo3.controladores.ataqueReagrupacionColocacion;

import edu.fiuba.algo3.controladores.ControladorMaestro;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class BotonReagruparEventHandler implements EventHandler<ActionEvent> {
    private ControladorMaestro controladorMaestro;
    private ComboBox desde;
    private ComboBox hacia;
    private ComboBox cantidad;
    private Label label;

    public BotonReagruparEventHandler(ControladorMaestro controladorMaestro, ComboBox paisesDesde, ComboBox paisesHacia, ComboBox cantidadDeFichas, Label errores) {
        this.controladorMaestro = controladorMaestro;
        desde = paisesDesde;
        hacia = paisesHacia;
        cantidad = cantidadDeFichas;
        this.label = errores;
    }

    @Override
    public void handle(ActionEvent event) {
        ArrayList<String> valores = controladorMaestro.paisesPuedenReagrupar();
        if (desde.getValue() == null || hacia.getValue() == null ){
            this.label.setText("Ambos Paises Deben Estar Completos");
            this.label.setTextFill(Color.RED);
            return;
        }
        if (cantidad.getValue() == null){
            this.label.setText("Debes Seleccionar Una Cantidad De Tropas");
            this.label.setTextFill(Color.RED);
            return;
        }
        controladorMaestro.reagrupar((String) desde.getValue(), (String) hacia.getValue(), (int )cantidad.getValue() );
        desde.getItems().removeAll(valores);
        valores = controladorMaestro.paisesPuedenReagrupar();
        desde.getItems().addAll(valores);

        hacia.getItems().clear();
        cantidad.getItems().clear();

        this.label.setText("Tropas Reagrupadas");
        this.label.setTextFill(Color.GREEN);
    }
}
