package edu.fiuba.algo3.vistas.escenasDeInformacion;

import edu.fiuba.algo3.controladores.informacion.BotonVolverATableroEventHandler;
import edu.fiuba.algo3.controladores.ControladorMaestro;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class EscenaMostrarPaises {

    public static Scene crearEscenaMostrarPaises(Stage stage, ControladorMaestro controladorMaestro, Scene sceneActual) {
        String[] coloresHex = {"cc3311", "0077bb", "009988", "ee7733", "ee3377", "000000"};
        Integer colorJugador = 0;
        HBox columnas = new HBox();
        columnas.setAlignment(Pos.TOP_CENTER);
        columnas.setSpacing(40);

        Button botonVolver = new Button("Volver al tablero");
        botonVolver.setOnAction(new BotonVolverATableroEventHandler(stage, sceneActual));
        ArrayList<ArrayList<String>> paises = controladorMaestro.paisesPorJugador();
        Label tope = new Label("Pais - Cantidad Ejercito");
        tope.setFont(new Font(34));
        VBox vBox = new  VBox(tope, columnas, botonVolver);
        vBox.setAlignment(Pos.CENTER);
        ScrollPane panelCentral = new ScrollPane(vBox);


        for (ArrayList<String> jugador : paises) {
            VBox columnaIndividual = new VBox();
            columnaIndividual.setAlignment(Pos.CENTER);
            String nombreJugador = jugador.get(0);
            Label nombreJugadorLabel = new Label(nombreJugador);
            nombreJugadorLabel.setFont(new Font(30));
            nombreJugadorLabel.setTextFill(Color.web(coloresHex[colorJugador]));
            colorJugador++;
            columnaIndividual.getChildren().add(nombreJugadorLabel);
            for (String elemento : jugador) {
                if (elemento.equals(jugador.get(0))) {continue;}

                Label paisActual = new Label(elemento + " - " + (controladorMaestro.tropasDisponiblesEn(elemento) + 1));
                paisActual.setFont(new Font(20));
                columnaIndividual.getChildren().add(paisActual);
            }
            columnas.getChildren().add(columnaIndividual);
        }
        panelCentral.setFitToHeight(true);
        panelCentral.setFitToWidth(true);
        Scene scenePaises = new Scene(panelCentral ,1080, 720);

        return scenePaises;
    }
}
