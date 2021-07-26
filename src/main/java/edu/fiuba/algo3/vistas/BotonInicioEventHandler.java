package edu.fiuba.algo3.vistas;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BotonInicioEventHandler implements EventHandler<ActionEvent> {
    private Stage stage;

    public BotonInicioEventHandler(Stage stageRecibida) {
        stage = stageRecibida;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        var label = new Label("Nueva Fase");
        Button botonEnviar = new Button();
        botonEnviar.setText("Enviar");
        final ComboBox cantJugadoresBox = new ComboBox();
        cantJugadoresBox.getItems().addAll(
                "2",
                "3",
                "4",
                "5",
                "6"
        );
        VBox vbox = new VBox();

        cantJugadoresBox.setOnAction(new EnviarCantJugadoresEventHandler(vbox,cantJugadoresBox));

        Label alertaJugadoreVacios = new Label();
        botonEnviar.setOnAction(new BotonConfirmarJugadoresEventHandler(vbox,alertaJugadoreVacios,stage));

        var sceneNueva = new Scene(new HBox(label,vbox,cantJugadoresBox,botonEnviar,alertaJugadoreVacios), 1080, 720);
        stage.setScene(sceneNueva);

        stage.show();

    }
}