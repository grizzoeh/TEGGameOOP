package edu.fiuba.algo3.controladores;

public class ProveedorDeConstantes {
    public static String obtenerIconoResultadoAtaque;
    private static String direccionIcono = "file:recursos/imagenes/tegIcono.jpg";
    private static String direccionMapa = "file:recursos/imagenes/mapaTeg.png" ;
    private static String direccionTablero = "recursos/archivosDeTexto/fronteras.csv";
    private static String direccionIconoObjetivoSecreto = "file:recursos/imagenes/pngtree-spy-glyph.jpg";
    private static String direccionIconoAlertaExit = "file:recursos/imagenes/cerrarIcono.jpg";
    private static String direccionSonidoTambores = "recursos/sonidos/tamboresAlInicio.aiff";
    private static String direccionSonidoVictoria = "recursos/sonidos/victoria.aiff";
    private static String direccionIconoResultadoAtaque = "file:recursos/imagenes/iconoResultadoAtaque.jpg";

    public static String obtenerIconoDelJuego(){
        return direccionIcono;
    }
    public static String obtenerMapa(){
        return direccionMapa;
    }
    public static String obtenerDireccionTablero() {return direccionTablero;}
    public static String obtenerDireccionIconoAlerta(){ return direccionIconoAlertaExit;}
    public static String obtenerDireccionIconoObjetivo(){ return direccionIconoObjetivoSecreto;}
    public static String obtenerSonidoTambores(){
        return direccionSonidoTambores;
    }
    public static String obtenerSonidoVictoria(){ return  direccionSonidoVictoria; }
    public static String obtenerIconoResultadoAtaque(){return direccionIconoResultadoAtaque;}

}
