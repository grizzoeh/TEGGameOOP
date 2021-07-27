package edu.fiuba.algo3;

import edu.fiuba.algo3.vistas.BotonConfirmarJugadoresEventHandler;
import edu.fiuba.algo3.vistas.BotonInicioEventHandler;
import edu.fiuba.algo3.vistas.BotonObjetivoEventHandler;
import edu.fiuba.algo3.vistas.EnviarCantJugadoresEventHandler;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var label = new Label("Bienvenido al Juego Teg");
        label.setFont(new Font("Serif", 24));

        Button boton = new Button();
        boton.setText("Iniciar Juego");
        boton.setPrefSize(240,60);
        boton.setFont(new Font("Serif", 20));

        VBox contenedorPrincipal = new VBox(label,boton);
        contenedorPrincipal.setSpacing(20);
        contenedorPrincipal.setAlignment(Pos.CENTER);
        var sceneBienvenida = new Scene(new StackPane(contenedorPrincipal), 1080, 720);
        var sceneCreacionJugadores = crearSceneJugadores(stage);
        boton.setOnAction(new BotonInicioEventHandler(stage,sceneCreacionJugadores));
        stage.setScene(sceneBienvenida);
        stage.setTitle("Teg");
        stage.getIcons().add(new Image("file:imagenes/tegIcono.jpg"));
        stage.show();

    }

    public Scene crearSceneJugadores(Stage stage){
        Scene sceneSiguiente = crearSceneEtapaInicial(stage);
        var label = new Label("Seleccione la cantidad de jugadores:\t");
        label.setFont(new Font("Serif", 18));

        Button botonEnviar = new Button();
        botonEnviar.setText("Enviar");
        botonEnviar.setFont(new Font(12));
        botonEnviar.setPrefSize(60,20);

        ComboBox cantJugadoresBox = new ComboBox();
        cantJugadoresBox.getItems().addAll(
                "2",
                "3",
                "4",
                "5",
                "6"
        );

        Label alertaJugadoreVacios = new Label();
        VBox vbox = new VBox();
        HBox contenedorSuperior = new HBox(label,cantJugadoresBox);
        HBox contenedorCentral = new HBox(vbox);
        VBox contenedorInferior = new VBox(botonEnviar, alertaJugadoreVacios);

        contenedorSuperior.setAlignment(Pos.TOP_CENTER);
        contenedorCentral.setAlignment(Pos.CENTER);
        contenedorCentral.setSpacing(10);
        contenedorInferior.setAlignment(Pos.CENTER);

        VBox contenedor = new VBox(contenedorSuperior,contenedorCentral,contenedorInferior);
        contenedorCentral.setSpacing(46);
        cantJugadoresBox.setOnAction(new EnviarCantJugadoresEventHandler(vbox,cantJugadoresBox));
        contenedor.setAlignment(Pos.CENTER);

        botonEnviar.setOnAction(new BotonConfirmarJugadoresEventHandler(vbox,alertaJugadoreVacios,stage,sceneSiguiente,cantJugadoresBox));

        var sceneNueva = new Scene(new StackPane(contenedor), 1080, 720);

        return sceneNueva;
    }

    private HBox crearImagenJuego() {
        Image image = new Image("file:imagenes/mapaTeg.png");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setX(10);
        imageView.setY(10);
        imageView.setFitWidth(900);
        imageView.setPreserveRatio(true);

        HBox caja = new HBox(imageView);
        return caja;
    }


    public Scene crearSceneEtapaInicial(Stage stage) {
        HBox imageView = crearImagenJuego();

        var nombre = new Label("Nombre: ");
        var color = new Label("Color: ");

        //no funciona xd
        Button objetivoButton = new Button();
        objetivoButton.setText("Ver Objetivo");
        objetivoButton.setFont(new Font(12));
        objetivoButton.setOnAction(new BotonObjetivoEventHandler(stage));

        var etapa = new Label("Etapa Inicial:\t");
        etapa.setFont(new Font("Serif", 18));


        VBox conteSupDer = new VBox(nombre, color, objetivoButton);
        conteSupDer.setAlignment(Pos.TOP_RIGHT);

        HBox contInfIzq = new HBox(etapa);
        contInfIzq.setAlignment(Pos.BOTTOM_LEFT);

        var sceneNueva = new Scene(new StackPane(conteSupDer,contInfIzq,imageView), 1080, 720);

        return sceneNueva;
    }


    public static void main(String[] args) {
        launch();
    }

}