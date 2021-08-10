package edu.fiuba.algo3.vistas.escenasGenerales;

import edu.fiuba.algo3.controladores.introducirJugadores.BotonConfirmarJugadoresEventHandler;
import edu.fiuba.algo3.controladores.introducirJugadores.EnviarCantJugadoresEventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class EscenaIntroducirJugadores {
    public static Scene crearSceneJugadores(Scene escena, Stage stage){
        
        var label = new Label("Seleccione la cantidad de jugadores:\t");
        label.setFont(new Font("Serif", 18));

        Button botonEnviar = new Button();
        botonEnviar.setText("Enviar");
        botonEnviar.setFont(new Font(12));
        botonEnviar.setPrefSize(60,20);

        ComboBox cantJugadoresBox = new ComboBox();
        cantJugadoresBox.getItems().addAll(
                "2",
                "3",
                "4",
                "5",
                "6"
        );

        Label alertaJugadoreVacios = new Label();

        VBox vbox = new VBox();

        HBox contenedorSuperior = new HBox(label,cantJugadoresBox);
        contenedorSuperior.setAlignment(Pos.TOP_CENTER);

        HBox contenedorCentral = new HBox(vbox);
        contenedorCentral.setAlignment(Pos.CENTER);
        contenedorCentral.setSpacing(46);

        VBox contenedorInferior = new VBox(botonEnviar, alertaJugadoreVacios);

        contenedorInferior.setAlignment(Pos.CENTER);

        VBox contenedor = new VBox(contenedorSuperior,contenedorCentral,contenedorInferior);
        contenedor.setAlignment(Pos.CENTER);

        cantJugadoresBox.setOnAction(new EnviarCantJugadoresEventHandler(vbox,cantJugadoresBox, botonEnviar));
        vbox.setSpacing(5);
        contenedor.setSpacing(10);

        botonEnviar.setOnAction(new BotonConfirmarJugadoresEventHandler(vbox,alertaJugadoreVacios,stage,cantJugadoresBox));

        Scene sceneNueva = new Scene(new StackPane(contenedor), 1080, 720);

        return sceneNueva;
    }
}
