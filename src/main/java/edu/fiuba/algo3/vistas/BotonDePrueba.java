package edu.fiuba.algo3.vistas;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BotonDePrueba<palabras> extends Application {
        ArrayList<String> palabras = new ArrayList();


    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("Titulo");

        Label comentario = new Label();


        Button boton = new Button("Presiona aqui");

        TextField texto = new TextField();
        texto.setPromptText("Ingrese el texto deseado");

        boton.setOnAction(new BotonPruebaEventHandler(comentario,texto,palabras));

        LectorDeTextoEventHandler textoEventHandler = new LectorDeTextoEventHandler(boton);
        texto.setOnKeyPressed(textoEventHandler);


        HBox contenedorPrincipal = new HBox(boton, comentario);

        contenedorPrincipal.setSpacing(20);
        contenedorPrincipal.setPadding(new Insets(2));

        VBox contenedorGeneral = new VBox(texto, contenedorPrincipal);

        contenedorGeneral.setSpacing(20);
        contenedorGeneral.setPadding(new Insets(2));

        StackPane layout = new StackPane(contenedorGeneral);

        Scene scene = new Scene(layout, 300,250);

        stage.setScene(scene);
        stage.show();
        System.out.println("Hola");
        System.out.println(palabras);
    }
}
