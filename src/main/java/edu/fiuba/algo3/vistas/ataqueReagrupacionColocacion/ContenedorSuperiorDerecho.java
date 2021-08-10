package edu.fiuba.algo3.vistas.ataqueReagrupacionColocacion;

import edu.fiuba.algo3.controladores.informacion.BotonMostrarPaisesHandler;
import edu.fiuba.algo3.controladores.informacion.BotonMostrarTarjetasEventHandler;
import edu.fiuba.algo3.controladores.informacion.BotonObjetivoEventHandler;
import edu.fiuba.algo3.controladores.ControladorMaestro;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ContenedorSuperiorDerecho {
    public static VBox crearContenedor(Stage stage , ControladorMaestro controladorMaestro){
        String colorConCodigo = controladorMaestro.colorJugadorActual();
        String[] codigoColor = colorConCodigo.split("-");

        Label nombre = new Label("Jugador Actual: " + controladorMaestro.nombreJugadorActual());
        nombre.setFont(new Font(13));
        Label nombreColor = new Label("Color: " );
        nombreColor.setFont(new Font(13));
        Label color = new Label( codigoColor[0]);
        color.setFont(new Font(13));
        Label cantidadPaises = new Label("Cantidad Paises: " + controladorMaestro.paisesDominadosPorJugActual() + "/50");
        cantidadPaises.setFont(new Font(13));

        HBox hBox = new HBox(nombreColor, color );
        color.setTextFill(Color.web(codigoColor[1]));

        Button objetivoButton = new Button();
        objetivoButton.setText("Ver Objetivo");
        objetivoButton.setFont(new Font(13));
        objetivoButton.setOnAction(new BotonObjetivoEventHandler(controladorMaestro));

        Button paisesButton = new Button();
        paisesButton.setText("Ver paises");
        paisesButton.setFont(new Font(13));
        paisesButton.setOnAction(new BotonMostrarPaisesHandler(stage , controladorMaestro));

        Button tarjetasButton = new Button();
        tarjetasButton.setText("Ver tarjetas");
        tarjetasButton.setFont(new Font(13));
        tarjetasButton.setOnAction(new BotonMostrarTarjetasEventHandler(stage , controladorMaestro));

        VBox contenedor = new VBox(nombre, hBox, cantidadPaises,objetivoButton, paisesButton, tarjetasButton);
        contenedor.setAlignment(Pos.TOP_CENTER);
        return contenedor;
    }
}
