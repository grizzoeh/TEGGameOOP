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
    private Scene scene;

    public BotonInicioEventHandler(Stage stageRecibida,Scene sceneRecibida) {
        stage = stageRecibida;
        scene = sceneRecibida;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.setScene(scene);

        stage.show();

    }
}