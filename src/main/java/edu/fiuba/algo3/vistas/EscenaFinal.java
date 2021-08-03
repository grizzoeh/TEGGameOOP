package edu.fiuba.algo3.vistas;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class EscenaFinal {


     public static Scene crearEscenaFinal(Stage stage, String nombreGanador, String colorGanador){
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
         return new Scene(vBox, 1080, 720);
    }
}
