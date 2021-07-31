package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.BotonObjetivoEventHandler;
import edu.fiuba.algo3.controladores.ControladorMaestro;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class ContenedorSuperiorDerecho {
    public static VBox crearContenedor(ControladorMaestro controladorMaestro){
        Label nombre = new Label("Nombre: " + controladorMaestro.nombreJugadorActual());
        Label color = new Label("Color: " + controladorMaestro.colorJugadorActual());

        Button objetivoButton = new Button();
        objetivoButton.setText("Ver Objetivo");
        objetivoButton.setFont(new Font(12));
        objetivoButton.setOnAction(new BotonObjetivoEventHandler(controladorMaestro));

        VBox contenedor = new VBox(nombre, color, objetivoButton);
        return contenedor;
    }
}
