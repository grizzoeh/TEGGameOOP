package edu.fiuba.algo3.controladores.ataqueReagrupacionColocacion;

import edu.fiuba.algo3.controladores.ControladorMaestro;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;

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
        ArrayList<String> paisesAtacables;

        if (paisesDesde.getValue() != null){
            paisesAtacables = controladorMaestro.paisesQueSePuedenAtacarDesde((String) paisesDesde.getValue());
            if (paisesAtacables.size() == 0){
                paisesHacia.setPromptText("Conquistaste Toda Su Frontera!");
                return;
            }
            colocarCantidad();
            paisesHacia.getItems().addAll(paisesAtacables);
        }
    }
    public void colocarCantidad(){
        for (int i = 0; i < controladorMaestro.tropasDisponiblesEn((String) paisesDesde.getValue()) && i < 3; i++ ){
            cantidad.getItems().add(i+1);
        }

    }
}
