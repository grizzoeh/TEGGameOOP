package edu.fiuba.algo3.controladores.ataqueReagrupacionColocacion;

import edu.fiuba.algo3.controladores.ControladorMaestro;
import edu.fiuba.algo3.controladores.ProveedorDeConstantes;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

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
        ArrayList<String> resultado = controladorMaestro.atacar((String) desde.getValue(), (String) hacia.getValue(), (int )cant.getValue());

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Resultado ataque");
        alerta.setHeaderText(resultado.get(0));
        alerta.setContentText(resultado.get(1) +"\n"  + resultado.get(2));
        ((Stage)alerta.getDialogPane().getScene().getWindow()).getIcons().add(new Image(ProveedorDeConstantes.obtenerIconoResultadoAtaque()));
        alerta.showAndWait();

        desde.getItems().clear();
        desde.getItems().addAll(controladorMaestro.paisesPuedenAtacar());


        hacia.getItems().clear();
        cant.getItems().clear();
    }
}
