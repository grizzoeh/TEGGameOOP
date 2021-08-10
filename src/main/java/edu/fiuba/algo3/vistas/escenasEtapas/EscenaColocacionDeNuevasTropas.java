package edu.fiuba.algo3.vistas.escenasEtapas;

import edu.fiuba.algo3.controladores.ataqueReagrupacionColocacion.BotonAvanzarAAtaqueEventHandler;
import edu.fiuba.algo3.controladores.canjearTarjeta.BotonCanjearTarjetasEventHandler;
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

public class EscenaColocacionDeNuevasTropas {

    public static Scene crearEscenaColocacion(Stage stage, ControladorMaestro controladorMaestro){
        ImageView imageView = LectorDeImagenMapa.crearImagenDelMapa();

        VBox contSupDer = ContenedorSuperiorDerecho.crearContenedor(stage, controladorMaestro);
        contSupDer.setSpacing(10);

        var etapa = new Label("ETAPA DE COLOCACION");
        etapa.setFont(new Font("Serif", 18));

        Button avanzarButton = new Button();

        Button canjearTarjetas = new Button();
        HBox seleccionador = SelectorDeColocacion.crearSelector(canjearTarjetas, avanzarButton, controladorMaestro);

        Label error = new Label("");

        canjearTarjetas.setText("Canjear Tarjetas");
        canjearTarjetas.setOnAction(new BotonCanjearTarjetasEventHandler(stage, controladorMaestro, error));


        seleccionador.setSpacing(10);

        VBox contInfIzq = new VBox(etapa,seleccionador);
        contInfIzq.setPadding(new Insets(1));

        HBox contSuperior = new HBox(imageView,contSupDer);
        contSuperior.setSpacing(5);
        HBox contInferior = new HBox(contInfIzq, error);


        VBox contenedor = new VBox(contSuperior,contInferior);
        contenedor.setPadding(new Insets(10));

        Scene sceneNueva = new Scene(contenedor, 1080, 720);


        avanzarButton.setOnAction(new BotonAvanzarAAtaqueEventHandler(stage, controladorMaestro));

        return sceneNueva;

    }
}
