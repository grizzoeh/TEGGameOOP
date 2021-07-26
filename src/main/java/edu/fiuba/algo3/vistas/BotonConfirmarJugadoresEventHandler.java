package edu.fiuba.algo3.vistas;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BotonConfirmarJugadoresEventHandler implements EventHandler<ActionEvent> {
    private VBox vbox;
    private Label label;
    private Stage stage;
    private Scene scene;

    public BotonConfirmarJugadoresEventHandler(VBox VBoxrecibida, Label labelRecibida, Stage stageRecibida, Scene sceneRecibida) {

        stage = stageRecibida;
        vbox = VBoxrecibida;
        label = labelRecibida;
        scene = sceneRecibida;

    }

    @Override
    public void handle(ActionEvent actionEvent) {


        Integer cantJugadores = vbox.getChildren().size();
        ArrayList<String> nombresJugadores = new ArrayList();


        for (Integer i = 0; i<cantJugadores; i++){
            TextField textFieldAux = (TextField) vbox.getChildren().get(i);
            String nombreJugador = textFieldAux.getText().trim();
            if (nombreJugador.equals("")){
                label.setText("Completar campos de Jugadores");
                label.setTextFill(Color.RED);
                textFieldAux.requestFocus();
                return;
            }
            if(nombresJugadores.contains(nombreJugador)){
                label.setText("Jugador repetido");
                label.setTextFill(Color.RED);
                textFieldAux.requestFocus();
                return;
            }
            nombresJugadores.add(nombreJugador);


        }
        stage.setScene(scene);

        stage.show();



    }
}