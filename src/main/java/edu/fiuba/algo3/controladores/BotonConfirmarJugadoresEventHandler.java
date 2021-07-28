package edu.fiuba.algo3.controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BotonConfirmarJugadoresEventHandler implements EventHandler<ActionEvent> {
    private VBox vbox;
    private Label label;
    private Stage stage;
    private Scene scene;
    private ComboBox jugadoresBox;

    public BotonConfirmarJugadoresEventHandler(VBox VBoxrecibida, Label labelRecibida, Stage stageRecibida, Scene sceneRecibida, ComboBox jugadoresBoxRecibida) {

        stage = stageRecibida;
        vbox = VBoxrecibida;
        label = labelRecibida;
        scene = sceneRecibida;
        jugadoresBox = jugadoresBoxRecibida;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(jugadoresBox.getSelectionModel().isEmpty()){
            label.setText("Seleccionar cantidad de jugadores.");
            label.setTextFill(Color.RED);
            label.setFont(new Font(14));
            return;
        }

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
        try {
            reproducirAudio("recursos/sonidos/tamboresAlInicio.aiff");
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);


        stage.show();



    }
    public void reproducirAudio(String file)throws UnsupportedAudioFileException,
            IOException, LineUnavailableException {
        Clip clip;
        AudioInputStream audioStream;
        audioStream = AudioSystem.getAudioInputStream(new File(file).getAbsoluteFile());

        clip = AudioSystem.getClip();

        clip.open(audioStream);
        clip.start();


    }

    }

