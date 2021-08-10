package edu.fiuba.algo3.controladores.canjearTarjeta;

import edu.fiuba.algo3.controladores.ControladorMaestro;
import edu.fiuba.algo3.controladores.ProveedorDeConstantes;
import edu.fiuba.algo3.modelo.objetivosytarjetas.Tarjeta;
import edu.fiuba.algo3.vistas.ataqueReagrupacionColocacion.EscenaCanjearTarjetas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BotonCanjeMultipleEventHandler implements EventHandler<ActionEvent> {
    private ControladorMaestro controladorMaestro;
    private HBox canjeMultiple;
    private Label error;
    private ArrayList<Tarjeta> tarjetas;
    private Stage stage;
    private Scene escenaAnterior;

    public BotonCanjeMultipleEventHandler(ControladorMaestro controladorMaestro, HBox canjeMultiple, Label error, Stage stage, Scene escenaAnterior) {
        this.controladorMaestro = controladorMaestro;
        this.canjeMultiple = canjeMultiple;
        this.error = error;
        this.stage = stage;
        this.escenaAnterior = escenaAnterior;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        String pais1 = ((ComboBox<String>) canjeMultiple.getChildren().get(0)).getValue();
        String pais2 = ((ComboBox<String>) canjeMultiple.getChildren().get(1)).getValue();
        String pais3 = ((ComboBox<String>) canjeMultiple.getChildren().get(2)).getValue();

        if (pais1 == null || pais2 == null || pais3 == null) {
            error.setText("Todos los campos deben estar completos");
            error.setTextFill(Color.RED);
            return;
        }

        pais1 = pais1.split(" - ")[0];
        pais2 = pais2.split(" - ")[0];
        pais3 = pais3.split(" - ")[0];

        if (!controladorMaestro.sePuedenCanjearTarjetas(pais1, pais2, pais3)) {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Canje Inválido");
            alerta.setHeaderText("No es posible realizar el canje.");
            alerta.setContentText("Para realizar el canje se debe cumplir que:"
                    +"\n\t- Las tres tarjetas deben ser del mismo símbolo."
                    +"\n\t- Las tres tarjetas deben ser de distinto símbolo.");
            ((Stage)alerta.getDialogPane().getScene().getWindow()).getIcons().add(new Image(ProveedorDeConstantes.obtenerDireccionIconoAlerta()));
            alerta.showAndWait();
        }
        controladorMaestro.canjearTarjetaMultiple(pais1, pais2, pais3);

        Alert alerta2 = new Alert(Alert.AlertType.INFORMATION);
        alerta2.setTitle("Canje Realizado");
        alerta2.setHeaderText("Canje Realizado");
        ((Stage)alerta2.getDialogPane().getScene().getWindow()).getIcons().add(new Image(ProveedorDeConstantes.obtenerDireccionIconoAlerta()));
        alerta2.showAndWait();

        Scene escenaNuevaCanje = EscenaCanjearTarjetas.crearEscenaCanjearTarjetas(stage, controladorMaestro, escenaAnterior);
        stage.setScene(escenaNuevaCanje);
        stage.show();
    }
}
