package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.BotonMostrarPaisesHandler;
import edu.fiuba.algo3.controladores.BotonVolverATableroEventHandler;
import edu.fiuba.algo3.controladores.ControladorMaestro;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class EscenaMostrarPaises {

    public static Scene crearEscenaMostrarPaises(Stage stage, ControladorMaestro controladorMaestro, Scene sceneActual) {
        HBox columnas = new HBox();
        columnas.setAlignment(Pos.TOP_CENTER);
        columnas.setSpacing(40);

        Button botonVolver = new Button("Volver al tablero");
        botonVolver.setOnAction(new BotonVolverATableroEventHandler(stage, sceneActual));

        ScrollPane panelCentral = new ScrollPane(new VBox(columnas, botonVolver));

        ArrayList<ArrayList<String>> paises = controladorMaestro.paisesPorJugador();

        for (ArrayList<String> jugador : paises) {
            VBox columnaIndividual = new VBox();

            String nombreJugador = jugador.get(0);
            Label nombreJugadorLabel = new Label(nombreJugador);
            nombreJugadorLabel.setFont(new Font(30));
            columnaIndividual.getChildren().add(nombreJugadorLabel);

            for (String elemento : jugador) {
                if (elemento.equals(jugador.get(0))) {continue;}

                Label paisActual = new Label(elemento + " - " + (controladorMaestro.tropasDisponiblesEn(elemento) + 1));
                paisActual.setFont(new Font(20));
                columnaIndividual.getChildren().add(paisActual);
            }
            columnas.getChildren().add(columnaIndividual);
        }
        Scene scenePaises = new Scene(panelCentral ,1080, 720);

        return scenePaises;
    }
}
