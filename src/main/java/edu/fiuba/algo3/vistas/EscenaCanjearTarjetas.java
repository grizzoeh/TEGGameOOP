package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class EscenaCanjearTarjetas {

    public static Scene crearEscenaCanjearTarjetas(Stage stage, ControladorMaestro controladorMaestro) {
        ArrayList<String> tarjetas = controladorMaestro.mostrarTodasTarjetasJugadorActual();
        ArrayList<String> paises = controladorMaestro.paisesJugadorActual();

        VBox contenedorPrincipal = new VBox();

        for (String tarjeta : tarjetas) {
            String nombrePais = tarjeta.split(" - ")[0];

            if (paises.contains(nombrePais)) {
                Label paisLabel = new Label();
                Button botonCanjear = new Button();

                paisLabel.setText(nombrePais);
                botonCanjear.setText("Canjear Tarjeta");

                HBox paisYBoton = new HBox( paisLabel, botonCanjear);
                paisYBoton.setAlignment(Pos.CENTER);
                paisYBoton.setSpacing(30);

                botonCanjear.setOnAction(new BotonCanjeIndividualEventHandler(controladorMaestro, nombrePais, contenedorPrincipal, paisYBoton));

                contenedorPrincipal.getChildren().add(paisYBoton);
            }


        }



        HBox canjeMultiple = new HBox();
        ComboBox<String> opcion1 = new ComboBox<>();
        ComboBox<String> opcion2 = new ComboBox<>();
        ComboBox<String> opcion3 = new ComboBox<>();

        opcion1.getItems().addAll(tarjetas);
        opcion2.getItems().addAll(tarjetas);
        opcion3.getItems().addAll(tarjetas);

        opcion1.setOnAction(new ComboBoxElejirTarjetaEventHandler(tarjetas, opcion1, opcion2, opcion3));
        opcion2.setOnAction(new ComboBoxElejirTarjetaEventHandler(tarjetas, opcion2, opcion1, opcion3));
        opcion3.setOnAction(new ComboBoxElejirTarjetaEventHandler(tarjetas, opcion3, opcion2, opcion1));

        Button botonCanjeMultiple = new Button();
        botonCanjeMultiple.setText("Confirmar canje multiple");
        botonCanjeMultiple.setOnAction(new BotonCanjeMultipleEventHandler(controladorMaestro, canjeMultiple));

        canjeMultiple.getChildren().add(opcion1);
        canjeMultiple.getChildren().add(opcion2);
        canjeMultiple.getChildren().add(opcion3);
        canjeMultiple.getChildren().add(botonCanjeMultiple);

        contenedorPrincipal.getChildren().add(canjeMultiple);

        // Reservado para canjear tarjetas

        Button botonVolver = new Button();
        botonVolver.setText("Continuar Juego");
        botonVolver.setOnAction(new BotonVolverATableroEventHandler(stage, stage.getScene()));

        contenedorPrincipal.getChildren().add(botonVolver);

        contenedorPrincipal.setAlignment(Pos.CENTER);


        return new Scene(contenedorPrincipal, 1080, 720);

    }
}
