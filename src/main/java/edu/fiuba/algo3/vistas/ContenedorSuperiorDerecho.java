package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.BotonObjetivoEventHandler;
import edu.fiuba.algo3.controladores.ControladorMaestro;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ContenedorSuperiorDerecho {
    public static VBox crearContenedor(ControladorMaestro controladorMaestro){
        String colorConCodigo = controladorMaestro.colorJugadorActual();
        String[] codigoColor = colorConCodigo.split("-");
        Label nombre = new Label("Nombre: " + controladorMaestro.nombreJugadorActual());
        Label nombreColor = new Label("Color: " );
        Label color = new Label( codigoColor[0]);
        Label cantidadPaises = new Label("Paises Dominados: " + controladorMaestro.paisesDominadosPorJugActual() + "/50");
        HBox hBox = new HBox(nombreColor, color );
        color.setTextFill(Color.web(codigoColor[1]));

        Button objetivoButton = new Button();
        objetivoButton.setText("Ver Objetivo");
        objetivoButton.setFont(new Font(12));
        objetivoButton.setOnAction(new BotonObjetivoEventHandler(controladorMaestro));

        VBox contenedor = new VBox(nombre, hBox, cantidadPaises,objetivoButton);
        return contenedor;
    }
}
