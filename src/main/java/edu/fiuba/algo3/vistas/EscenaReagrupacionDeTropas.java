package edu.fiuba.algo3.vistas;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class EscenaReagrupacionDeTropas {
    public static Scene crearEscenaReagrupacion(Scene escenaRecibida, Stage stage) {

        ImageView imageView = LectorDeImagenMapa.crearImagenDelMapa();


        Label etapa = new Label("Etapa De REAGRUPACION");
        etapa.setFont(new Font("Serif", 18));

        var paisesLabel = new Label("Desde:");
        ComboBox paisesDesde = new ComboBox();
        paisesDesde.getItems().addAll(
                "Paises Desde"
        );
        Label atacados = new Label("Hacia:");

        ComboBox paisesHacia = new ComboBox();
        paisesHacia.getItems().addAll(
                "Paises Hacia"
        );

        Button atacarButton = new Button();
        atacarButton.setText("Reagrupar");
        ComboBox cantidadDeFichas = new ComboBox();
        cantidadDeFichas.getItems().addAll(
                "Cantidad"
        );

        Label fichas = new Label("Fichas:");

        Button avanzarButton = new Button();
        avanzarButton.setText("Avanzar Etapa");
        avanzarButton.setAlignment(Pos.CENTER_RIGHT);

        VBox contSupDer = ContenedorSuperiorDerecho.crearContenedor();
        contSupDer.setSpacing(10);

        HBox seleccionador = new HBox(paisesLabel,paisesDesde, atacados, paisesHacia,fichas, cantidadDeFichas,atacarButton, avanzarButton);
        seleccionador.setSpacing(10);
        VBox contInfIzq = new VBox(etapa,seleccionador);
        contInfIzq.setPadding(new Insets(1));

        HBox contSuperior = new HBox(imageView,contSupDer);
        contSuperior.setSpacing(5);
        HBox contInferior = new HBox(contInfIzq);

        VBox contenedor = new VBox(contSuperior,contInferior);
        contenedor.setPadding(new Insets(10));

        Scene sceneNueva = new Scene(contenedor, 1080, 720);
        return sceneNueva;

    }
}
