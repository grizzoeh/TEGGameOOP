package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.ControladorMaestro;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class EscenaColocacionDeNuevasTropas {

    public static Scene crearEscenaColocacion(ControladorMaestro controladorMaestro){
        ImageView imageView = LectorDeImagenMapa.crearImagenDelMapa();

        VBox contSupDer = ContenedorSuperiorDerecho.crearContenedor(controladorMaestro);
        contSupDer.setSpacing(10);

        var etapa = new Label("ETAPA DE COLOCACION");
        etapa.setFont(new Font("Serif", 18));

        Button avanzarButton = new Button();

        HBox seleccionador = SelectorDeColocacion.crearSelector(avanzarButton, null); // CAMBIAR POR FAVOR

        seleccionador.setSpacing(10);
        VBox contInfIzq = new VBox(etapa,seleccionador);
        contInfIzq.setPadding(new Insets(1));

        HBox contSuperior = new HBox(imageView,contSupDer);
        contSuperior.setSpacing(5);
        HBox contInferior = new HBox(contInfIzq);

        VBox contenedor = new VBox(contSuperior,contInferior);
        contenedor.setPadding(new Insets(10));

        Scene sceneNueva = new Scene(contenedor, 1080, 720);

        //avanzarButton.setOnAction(Hay que generar un comportamiento );

        return sceneNueva;

    }
}
