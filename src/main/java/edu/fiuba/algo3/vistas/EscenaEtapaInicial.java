package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.BotonObjetivoEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class EscenaEtapaInicial {
    public static Scene crearSceneEtapaInicial(Scene escenaRecibida) {

        ImageView imageView = LectorDeImagenMapa.crearImagenDelMapa();

        var nombre = new Label("Nombre: NombreJug");
        var color = new Label("Color: ColorJug");

        Button objetivoButton = new Button();
        objetivoButton.setText("Ver Objetivo");
        objetivoButton.setFont(new Font(12));
        objetivoButton.setOnAction(new BotonObjetivoEventHandler());

        var etapa = new Label("Etapa Inicial");
        etapa.setFont(new Font("Serif", 18));
        var paisesLabel = new Label("Paises Disponibles:");
        ComboBox paises = new ComboBox();
        paises.getItems().addAll(
                "Paises..."
        );
        TextField cantFichas = new TextField();
        cantFichas.setPromptText("Fichas Disponibles: [X]");
        Button agregarButton = new Button();
        agregarButton.setText("Agregar");
        var fichas = new Label("Fichas:");
        Button avanzarButton = new Button();
        avanzarButton.setText("Terminar Turno");
        avanzarButton.setAlignment(Pos.CENTER_RIGHT);

        VBox contSupDer = new VBox(nombre, color, objetivoButton);
        contSupDer.setSpacing(10);
        HBox seleccionador = new HBox(paisesLabel,paises,fichas,cantFichas, agregarButton, avanzarButton);
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