package edu.fiuba.algo3.controladores.canjearTarjeta;

import edu.fiuba.algo3.controladores.ControladorMaestro;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class BotonCanjeIndividualEventHandler implements EventHandler<ActionEvent> {
    private ControladorMaestro controladorMaestro;
    private String pais;
    private VBox contenedorPrincipal;
    private HBox paisActual;

    public BotonCanjeIndividualEventHandler(ControladorMaestro controladorMaestro, String pais, VBox contenedorPrincipal, HBox paisActual) {
        this.controladorMaestro = controladorMaestro;
        this.pais = pais;
        this.contenedorPrincipal = contenedorPrincipal;
        this.paisActual = paisActual;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        controladorMaestro.canjearTarjetaIndividual(pais);

        contenedorPrincipal.getChildren().remove(paisActual);

        if (contenedorPrincipal.getChildren().size() == 0) {
            Label advertencia = new Label();
            advertencia.setText("Ya no hay tarjetas para canjear");
            advertencia.setTextFill(Color.RED);

            contenedorPrincipal.getChildren().add(advertencia);
        }

    }
}
