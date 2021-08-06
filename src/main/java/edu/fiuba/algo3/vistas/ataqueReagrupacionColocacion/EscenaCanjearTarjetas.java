package edu.fiuba.algo3.vistas.ataqueReagrupacionColocacion;

import edu.fiuba.algo3.controladores.*;
import edu.fiuba.algo3.controladores.canjearTarjeta.BotonCanjeIndividualEventHandler;
import edu.fiuba.algo3.controladores.canjearTarjeta.BotonCanjeMultipleEventHandler;
import edu.fiuba.algo3.controladores.canjearTarjeta.ComboBoxElejirTarjetaEventHandler;
import edu.fiuba.algo3.controladores.informacion.BotonVolverATableroEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class EscenaCanjearTarjetas {

    public static Scene crearEscenaCanjearTarjetas(Stage stage, ControladorMaestro controladorMaestro, Scene scene) {
        ArrayList<String> tarjetas = controladorMaestro.mostrarTodasTarjetasJugadorActual();
        ArrayList<String> paises = controladorMaestro.paisesJugadorActual();

        Label label = new Label("Canjear Tarjetas");
        label.setFont(new Font(35));
        Label labelCanje = new Label("Canjear Tarjetas Individualmente");
        labelCanje.setFont(new Font(25));
        Label labelCanjeMul = new Label("Canjear Varias Tarjetas");
        labelCanjeMul.setFont(new Font(25));

        Label resultadoCanje = new Label("");
        resultadoCanje.setFont(new Font(20));


        VBox contenedorTarjIndiv = new VBox();

        for (String tarjeta : tarjetas) {
            String nombrePais = tarjeta.split(" - ")[0];

            if (paises.contains(nombrePais)) {
                Label paisLabel = new Label();
                Button botonCanjear = new Button();
                paisLabel.setFont(new Font(14));
                paisLabel.setText(nombrePais);
                botonCanjear.setText("Canjear Tarjeta");
                botonCanjear.setFont(new Font(14));

                HBox paisYBoton = new HBox( paisLabel, botonCanjear);
                paisYBoton.setAlignment(Pos.CENTER);
                paisYBoton.setSpacing(30);

                botonCanjear.setOnAction(new BotonCanjeIndividualEventHandler(controladorMaestro, nombrePais, contenedorTarjIndiv , paisYBoton));

                contenedorTarjIndiv.getChildren().add(paisYBoton);
            }

        }
        if (contenedorTarjIndiv.getChildren().size() == 0){
            contenedorTarjIndiv.getChildren().add(new Label("No posees ningun pais de los que tienes tarjetas"));
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

        Label error = new Label();

        botonCanjeMultiple.setOnAction(new BotonCanjeMultipleEventHandler(controladorMaestro, canjeMultiple, error, stage, scene));

        canjeMultiple.getChildren().add(opcion1);
        canjeMultiple.getChildren().add(opcion2);
        canjeMultiple.getChildren().add(opcion3);
        canjeMultiple.getChildren().add(botonCanjeMultiple);
        canjeMultiple.setSpacing(5);

        Button botonVolver = new Button();
        botonVolver.setText("Continuar Juego");
        botonVolver.setOnAction(new BotonVolverATableroEventHandler(stage, scene));
        canjeMultiple.setAlignment(Pos.CENTER);
        contenedorTarjIndiv.setAlignment(Pos.CENTER);
        contenedorTarjIndiv.setSpacing(5);

        VBox contenedorGeneral = new VBox(labelCanje,contenedorTarjIndiv,labelCanjeMul, canjeMultiple,resultadoCanje, error);
        contenedorGeneral.setAlignment(Pos.CENTER);
        contenedorGeneral.setSpacing(30);

        VBox contenedor = new VBox(label, contenedorGeneral, botonVolver);
        contenedor.setPadding(new Insets(10));
        contenedor.setSpacing(40);
        contenedor.setAlignment(Pos.TOP_CENTER);

        return new Scene(contenedor, 1080, 720);
    }
}
