package edu.fiuba.algo3.vistas.escenasDeInformacion;

import edu.fiuba.algo3.controladores.informacion.BotonVolverATableroEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class EscenaReglas {
    public static Scene crearEscenaReglas(Stage stage){
        Label labelSuperior = new Label("Reglas:");
        labelSuperior.setFont(new Font(45));

        Label regla1 = new Label("- El juego consta de tres rondas por cada turno, las cuales van en este orden: ATAQUE - REAGRUPACION - COLOCACION.");
        Label regla2 = new Label("- El juego finaliza cuando el jugador cumplio su objetivo privado o cuando conquista 30 o más paises.");
        Label regla3 = new Label("- En la fase de colocacion, es posbible canjear tarjetas pais. Estas tarjetas se pueden usar de dos formas: \n \t + Se pueden intercambiar individualmente, siempre y cuando seas dueño del pais que corresponde a la tarjeta, \n \t \t canjear una tarjeta individualmente otorga dos tropas en dicho pais. \n \t + Canjear de a tres tarjetas, para ello las tres tarjetas deben tener el mismo simbolo o tres simbolos distintos, \n \t\tel canjear las tarjetas te dará tropas adicionales para colocar donde prefieras. ");
        Label regla4 = new Label("- Al comienzo de la partida, se repartiran todos los paises entre todos los jugadores existentes.");
        Label regla5 = new Label("- La resolución del ataque se realiza lanzando dados de manera aleatoria y depende de la cantidad de ejércitos que se decidan utilizar\n para realizarlo. Por otro lado, el defensor lanza tantos dados como ejércitos tenga en el país defensor, con un máximo de tres. ");
        VBox reglas = new VBox(regla4, regla1, regla2,regla5,regla3);
        regla1.setFont(new Font(15));
        regla2.setFont(new Font(15));
        regla3.setFont(new Font(15));
        regla4.setFont(new Font(15));
        regla5.setFont(new Font(15));
        Button botonVolver = new Button("Volver");
        botonVolver.setOnAction(new BotonVolverATableroEventHandler(stage, stage.getScene()));
        reglas.setPadding(new Insets(10));
        reglas.setSpacing(20);
        reglas.setAlignment(Pos.CENTER_LEFT);

        VBox contenedor = new VBox(labelSuperior,reglas, botonVolver);
        contenedor.setSpacing(40);
        contenedor.setAlignment(Pos.TOP_CENTER);
        Scene escenaReglas = new Scene(contenedor, 1080, 720);
        return escenaReglas;
    }
}
