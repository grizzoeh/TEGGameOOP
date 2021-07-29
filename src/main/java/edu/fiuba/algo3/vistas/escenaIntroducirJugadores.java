package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.BotonConfirmarJugadoresEventHandler;
import edu.fiuba.algo3.controladores.EnviarCantJugadoresEventHandler;
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

public class escenaIntroducirJugadores {
    public void crearSceneJugadores(Scene escena,Stage stage){
        escenaEtapaInicial escenaEtapaIni = new escenaEtapaInicial;
        Scene sceneSiguiente = escenaEtapaIni.crearSceneEtapaInicial();
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
        HBox contenedorCentral = new HBox(vbox);
        VBox contenedorInferior = new VBox(botonEnviar, alertaJugadoreVacios);

        contenedorSuperior.setAlignment(Pos.TOP_CENTER);
        contenedorCentral.setAlignment(Pos.CENTER);
        contenedorCentral.setSpacing(10);
        contenedorInferior.setAlignment(Pos.CENTER);

        VBox contenedor = new VBox(contenedorSuperior,contenedorCentral,contenedorInferior);
        contenedorCentral.setSpacing(46);
        cantJugadoresBox.setOnAction(new EnviarCantJugadoresEventHandler(vbox,cantJugadoresBox));
        contenedor.setAlignment(Pos.CENTER);

        botonEnviar.setOnAction(new BotonConfirmarJugadoresEventHandler(vbox,alertaJugadoreVacios,stage,sceneSiguiente,cantJugadoresBox));

        var sceneNueva = new Scene(new StackPane(contenedor), 1080, 720);

        return sceneNueva;
    }
}
