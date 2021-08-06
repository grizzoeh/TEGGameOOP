package edu.fiuba.algo3.vistas.escenasGenerales;

import edu.fiuba.algo3.controladores.ProveedorDeConstantes;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class EscenaFinal {


     public static Scene crearEscenaFinal(Stage stage, String nombreGanador, String colorGanador) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
         String[] colorDesarmado = colorGanador.split("-");
         Label felicitacion = new Label("¡Juego Finalizado!");
         felicitacion.setFont(new Font("Times",36));
         felicitacion.setTextFill(Color.RED);

         Label textoSup = new Label("Ha ganado");
         textoSup.setFont(new Font(35));

         Label anunciante =  new Label(nombreGanador);
         anunciante.setTextFill(Color.web(colorDesarmado[1]));
         anunciante.setFont(new Font(30));
         Label agradecimiento = new Label("Gracias Por Jugar!");
         agradecimiento.setFont(new Font(15));

         VBox vBox = new VBox(felicitacion,textoSup,anunciante, agradecimiento);
         vBox.setAlignment(Pos.CENTER);
         vBox.setSpacing(40);

         Clip clip;
         AudioInputStream audioStream;
         audioStream = AudioSystem.getAudioInputStream(new File(ProveedorDeConstantes.obtenerSonidoVictoria()).getAbsoluteFile());

         clip = AudioSystem.getClip();

         clip.open(audioStream);
         FloatControl gainControl =
                 (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
         gainControl.setValue(-5.0f); // Baja el volumen decibeles
         clip.start();

         return new Scene(vBox, 1080, 720);
    }
}
