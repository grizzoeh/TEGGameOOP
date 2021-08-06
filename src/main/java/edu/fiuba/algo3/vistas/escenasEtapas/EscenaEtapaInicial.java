package edu.fiuba.algo3.vistas.escenasEtapas;

import edu.fiuba.algo3.controladores.ataqueReagrupacionColocacion.BotonAvanzarAAtaqueEventHandler;
import edu.fiuba.algo3.controladores.ControladorMaestro;
import edu.fiuba.algo3.vistas.ataqueReagrupacionColocacion.ContenedorSuperiorDerecho;
import edu.fiuba.algo3.vistas.ataqueReagrupacionColocacion.LectorDeImagenMapa;
import edu.fiuba.algo3.vistas.ataqueReagrupacionColocacion.SelectorDeColocacion;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class EscenaEtapaInicial {
    public static Scene crearSceneEtapaInicial(Stage stage, ControladorMaestro controladorMaestro) {

        ImageView imageView = LectorDeImagenMapa.crearImagenDelMapa();


        VBox contSupDer = ContenedorSuperiorDerecho.crearContenedor(stage, controladorMaestro);
        contSupDer.setSpacing(10);


        var etapa = new Label("ETAPA INICIAL");
        etapa.setFont(new Font("Serif", 18));

        Button avanzarButton = new Button();
        Button botonOpc = new Button();
        HBox seleccionador = SelectorDeColocacion.crearSelector(botonOpc, avanzarButton, controladorMaestro);

        seleccionador.setSpacing(10);
        VBox contInfIzq = new VBox(etapa,seleccionador);
        contInfIzq.setPadding(new Insets(1));

        HBox contSuperior = new HBox(imageView,contSupDer);
        contSuperior.setSpacing(5);
        HBox contInferior = new HBox(contInfIzq);

        VBox contenedor = new VBox(contSuperior,contInferior);
        contenedor.setPadding(new Insets(10));

        seleccionador.getChildren().remove(botonOpc);
        avanzarButton.setOnAction(new BotonAvanzarAAtaqueEventHandler(stage, controladorMaestro));

        Scene sceneNueva = new Scene(contenedor, 1080, 720);


        return sceneNueva;
    }

}