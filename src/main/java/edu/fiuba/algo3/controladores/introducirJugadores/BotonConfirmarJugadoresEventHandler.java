package edu.fiuba.algo3.controladores.introducirJugadores;

import edu.fiuba.algo3.controladores.ControladorMaestro;
import edu.fiuba.algo3.controladores.ProveedorDeConstantes;
import edu.fiuba.algo3.modelo.excepciones.NombreInvalidoException;
import edu.fiuba.algo3.modelo.excepciones.NombreRepetidoException;
import edu.fiuba.algo3.vistas.escenasGenerales.EscenaColoresJugadores;
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
    private ComboBox jugadoresBox;

    public BotonConfirmarJugadoresEventHandler(VBox VBoxrecibida, Label labelRecibida, Stage stageRecibida, ComboBox jugadoresBoxRecibida) {

        stage = stageRecibida;
        vbox = VBoxrecibida;
        label = labelRecibida;
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

        try {


        for (Integer i = 0; i<cantJugadores; i++){
            TextField textFieldAux = (TextField) vbox.getChildren().get(i);
            String nombreJugador = textFieldAux.getText().trim();

            validarNombreValido(nombreJugador, label, textFieldAux);

            validarNombreNoRepetido(nombreJugador, nombresJugadores, label, textFieldAux);


            nombresJugadores.add(nombreJugador);
        }

        }catch (NombreInvalidoException e){
            e.printStackTrace();
            return;
        }
        catch (NombreRepetidoException e) {
            e.printStackTrace();
            return;
        }


        try {
            reproducirAudio(ProveedorDeConstantes.obtenerSonidoTambores());
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

        ControladorMaestro controladorMaestro = new ControladorMaestro(nombresJugadores);
        Scene scene = EscenaColoresJugadores.crearSceneColoresJugadores(stage, controladorMaestro, nombresJugadores);
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
        FloatControl gainControl =
                (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-10.0f); // Baja el volumen decibeles
        clip.start();


    }
    public void validarNombreValido(String nombre, Label label, TextField textFieldAux){
        if (nombre.equals("")){
            label.setText("Completar campos de Jugadores");
            label.setTextFill(Color.RED);
            textFieldAux.requestFocus();

            throw new NombreInvalidoException();
        }

    }
    public void validarNombreNoRepetido(String nombre, ArrayList<String> nombresJugadores, Label label, TextField textFieldAux){
        if(nombresJugadores.contains(nombre)){
            label.setText("Jugador repetido");
            label.setTextFill(Color.RED);
            textFieldAux.requestFocus();

            throw new NombreRepetidoException();
        }
    }
    }

