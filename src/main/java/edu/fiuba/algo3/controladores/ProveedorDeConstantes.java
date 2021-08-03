package edu.fiuba.algo3.controladores;

public class ProveedorDeConstantes {
    private static String direccionIcono = "file:recursos/imagenes/tegIcono.jpg";
    private static String direccionMapa = "file:recursos/imagenes/mapaTeg.png" ;
    private static String direccionSonidoTambores = "recursos/sonidos/tamboresAlInicio.aiff";
    private static String direccionTablero = "recursos/archivosDeTexto/fronteras.csv";
    private static String direccionIconoAlerta = "file:recursos/imagenes/pngtree-spy-glyph.jpg";


    public static String obtenerIconoDelJuego(){
        return direccionIcono;
    }
    public static String obtenerMapa(){
        return direccionMapa;
    }
    public static String obtenerSonidoTambores(){
        return direccionSonidoTambores;
    }
    public static String obtenerDireccionTablero() {return direccionTablero;}
    public static String obtenerDireccionIconoAlerta(){ return direccionIconoAlerta;}

}
