package edu.fiuba.algo3;

import edu.fiuba.algo3.controladores.titulo.BotonInicioEventHandler;
import edu.fiuba.algo3.controladores.ProveedorDeConstantes;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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
        var label = new Label("Bienvenido al Juego Teg");
        label.setFont(new Font("Serif", 24));


        Button boton = new Button();
        boton.setText("Iniciar Juego");
        boton.setPrefSize(240,60);
        boton.setFont(new Font("Serif", 20));

        VBox contenedorPrincipal = new VBox(label,boton);
        contenedorPrincipal.setSpacing(20);
        contenedorPrincipal.setAlignment(Pos.CENTER);

        Scene sceneBienvenida = new Scene(new StackPane(contenedorPrincipal), 1080, 720);


        boton.setOnAction(new BotonInicioEventHandler(stage, sceneBienvenida));

        stage.setScene(sceneBienvenida);
        stage.setTitle("TEG");
        stage.getIcons().add(new Image(ProveedorDeConstantes.obtenerIconoDelJuego()));
        stage.setOnCloseRequest(event -> {
                event.consume();
                cerrar(stage);
                });
        stage.show();

    }
    public void cerrar(Stage stage){
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Cerrar Juego");
        alerta.setHeaderText("Estas a punto de cerrar el juego!");
        alerta.setContentText("Estas seguro de que quieres salir?");
        ((Stage)alerta.getDialogPane().getScene().getWindow()).getIcons().add(new Image(ProveedorDeConstantes.obtenerDireccionIconoAlerta()));

        if (alerta.showAndWait().get() == ButtonType.OK){
            stage.close();
        }

    }

    public static void main(String[] args) {
        launch();
    }

}