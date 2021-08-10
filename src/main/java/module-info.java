module edu.fiuba.algo3 {
    requires javafx.controls;
    requires annotations;
    requires opencsv;
    requires java.desktop;
    exports edu.fiuba.algo3;
    exports edu.fiuba.algo3.modelo;
    exports edu.fiuba.algo3.controladores;
    exports edu.fiuba.algo3.modelo.objetivosytarjetas;
    exports edu.fiuba.algo3.modelo.distribuciondepaises;
    exports edu.fiuba.algo3.modelo.gestiondeturnos;
    exports edu.fiuba.algo3.controladores.titulo;
    exports edu.fiuba.algo3.controladores.introducirJugadores;
    exports edu.fiuba.algo3.controladores.mostrarJugadores;
    exports edu.fiuba.algo3.controladores.canjearTarjeta;
    exports edu.fiuba.algo3.controladores.ataqueReagrupacionColocacion;
    exports edu.fiuba.algo3.modelo.gestionDeCombate;
    exports edu.fiuba.algo3.modelo.componentesJugador;
    exports edu.fiuba.algo3.controladores.informacion;
}