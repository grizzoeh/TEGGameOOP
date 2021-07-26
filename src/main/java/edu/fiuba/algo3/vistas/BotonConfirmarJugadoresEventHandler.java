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

    public BotonConfirmarJugadoresEventHandler(VBox VBoxrecibida, Label labelRecibida, Stage stageRecibida) {

        stage = stageRecibida;
        vbox = VBoxrecibida;
        label = labelRecibida;

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
                return;
            }
            if(nombresJugadores.contains(nombreJugador)){
                label.setText("Jugador repetido");
                label.setTextFill(Color.RED);
                return;
            }
            nombresJugadores.add(nombreJugador);


        }
        var sceneNueva = new Scene(new HBox(label,vbox), 1080, 720);
        stage.setScene(sceneNueva);

        stage.show();



    }
}